package org.example;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/12/9 15:32
 **/
@Data
public class CollectionDTO {

    @ExcelProperty("序号")
    private String id;

    @ExcelProperty("结算时间")
    private Date settlementDate;

    @ExcelProperty("剩余收入")
    private BigDecimal price;
}
