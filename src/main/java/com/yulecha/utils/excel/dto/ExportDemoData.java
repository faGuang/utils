package com.yulecha.utils.excel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.sun.istack.NotNull;
import com.yulecha.utils.annotation.IsZeroConvertNull;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName：ExportDemoDate
 * @Description：
 * @Author：yulecha
 * @Date：2020/5/14 14:32
 * @Version 1.0
 **/
@Data
public class ExportDemoData {

    @ExcelProperty("字符串标题")
    private String string;

    @ExcelProperty("日期标题")
    @IsZeroConvertNull
    private BigDecimal num;
}
