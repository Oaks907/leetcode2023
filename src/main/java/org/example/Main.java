package org.example;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.util.StringUtils;
import com.google.common.collect.Maps;
import com.google.common.primitives.Doubles;
import org.apache.commons.compress.utils.Lists;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String refundFileName = "D:\\IdeaProjects\\leetcode2023\\src\\main\\resources\\11月小鹅通退款.xlsx";
        ArrayList<RefundDTO> refundList = Lists.newArrayList();
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(refundFileName, RefundDTO.class, new PageReadListener<RefundDTO>(dataList -> {
            for (RefundDTO demoData : dataList) {
//                System.out.println("读取到一条数据" + JSON.toJSONString(demoData));
                refundList.add(demoData);
            }})).sheet(0).doRead();

        // 小鹅通后台11月
        String collectionFileName = "D:\\IdeaProjects\\leetcode2023\\src\\main\\resources\\23.11小鹅通代收款统计.xlsx";

        List<CollectionDTO> monthDayList = Lists.newArrayList();
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(collectionFileName, CollectionDTO.class, new PageReadListener<CollectionDTO>(dataList -> {
            for (CollectionDTO demoData : dataList) {
//                System.out.println(demoData.getId() + " " + JSON.toJSON(demoData));
                if (demoData.getSettlementDate().after(new Date(1698768000000L))) {
                    monthDayList.add(demoData);
                }
            }
        })).sheet(2).doRead();

//        System.out.println(monthDayList);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Map<String, BigDecimal> monthDayMap = new LinkedHashMap<>();

        monthDayList.forEach(dto -> {
            BigDecimal price = dto.getPrice();
            String key = simpleDateFormat.format(dto.getSettlementDate());
            monthDayMap.put(key, price.add(monthDayMap.getOrDefault(key, new BigDecimal(0))));
        });

        System.out.println(monthDayMap);

        System.out.println("-------------AAAAAaaaaaaaaaaaaaaaaaaaaaaaa-------");


        List<CollectionBankFlowingDTO> totalDayList = Lists.newArrayList();
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(collectionFileName, CollectionBankFlowingDTO.class, new PageReadListener<CollectionBankFlowingDTO>(dataList -> {
            for (CollectionBankFlowingDTO demoData : dataList) {
                if (StringUtils.isBlank(demoData.getDate())) {
                    System.out.println(demoData);
                    continue;
                }
                if (Objects.isNull(demoData.getPrice())) {
                    System.out.println(demoData);
                    continue;
                }
                demoData.setDate(demoData.getDate().replace("-", "").replace("/", ""));

                Double number = Doubles.tryParse(demoData.getDate());
                if (Objects.isNull(number) || demoData.getDate().length() != 8) {
                    System.out.println(demoData);
                    continue;
                }

//                System.out.println( " " + JSON.toJSON(demoData));



                totalDayList.add(demoData);

            }
        })).sheet(3).doRead();

        Map<String, BigDecimal> totalMap = new LinkedHashMap<>();
        totalDayList.forEach(dto -> {
            BigDecimal price = dto.getPrice();
            String key = String.valueOf(Long.parseLong(dto.getDate()) - 1);
            totalMap.put(key, price.add(totalMap.getOrDefault(key, new BigDecimal(0))));
        });

        System.out.println(monthDayMap);
        System.out.println(totalMap);


        Map<String, BigDecimal> result = monthDayMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Map<String, BigDecimal> diffMap = Maps.newLinkedHashMap();
        for (Map.Entry<String, BigDecimal> entry : result.entrySet()) {
            String timeKey = entry.getKey();
            BigDecimal sum = entry.getValue();
            if (totalMap.containsKey(timeKey)) {
                BigDecimal totalSta = totalMap.get(timeKey);
                if (totalSta.equals(sum)) {
                    System.out.println(timeKey + "相等");
                } else {
                    System.out.println(timeKey + "不相等，day：" + sum + ", total:" + totalSta);
                    diffMap.put(timeKey, sum.subtract(totalSta));
                }
            } else {
                System.out.println(timeKey + "只有小鹅通：" + sum);
                diffMap.put(timeKey, sum);
            }
        }

        BigDecimal sum1 = new BigDecimal(0);
        BigDecimal sum2 = new BigDecimal(0);
        for (Map.Entry<String, BigDecimal> entry : diffMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            sum1 = sum1.add(entry.getValue());
        }

        for (RefundDTO refundDTO : refundList) {
            sum2 = sum2.add(refundDTO.getPrice()).add(new BigDecimal("7.68"));
        }

        System.out.println("总和：" + sum1 + ", 退款：" + sum2 + ", 和：" + sum1.add(sum2));


//        String flowingFileName = "D:\\IdeaProjects\\leetcode2023\\src\\main\\resources\\银行流水录单-11月.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(flowingFileName, FlowingDTO.class, new PageReadListener<FlowingDTO>(dataList -> {
//            for (FlowingDTO refundDTO : dataList) {
//                System.out.println("读取到一条数据{}" + JSON.toJSONString(refundDTO));
//            }})).sheet().doRead();
    }
}