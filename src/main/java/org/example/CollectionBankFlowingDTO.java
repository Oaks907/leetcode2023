package org.example;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/12/9 15:32
 **/
@Data
public class CollectionBankFlowingDTO {
    @ExcelProperty(index = 2)
    private String date;

    @ExcelProperty(index = 5)
    private BigDecimal price;
}
