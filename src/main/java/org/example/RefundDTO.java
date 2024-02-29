package org.example;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 小鹅通退款类
 *
 * @Description
 * @Author Administrator
 * @Date 2023/12/9 14:57
 **/
@Data
public class RefundDTO {

    @ExcelProperty("内部订单号")
    private String id;

    @ExcelProperty("结算时间")
    private Date time;

    @ExcelProperty("交易金额(元)")
    private BigDecimal price;
}
