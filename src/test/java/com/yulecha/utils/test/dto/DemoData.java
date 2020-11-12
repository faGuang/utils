package com.yulecha.utils.test.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName：DemoData
 * @Description：
 * @Author：yulecha
 * @Date：2020/4/22 18:01
 * @Version 1.0
 **/
@Data
public class DemoData {
    @ExcelProperty(value = "单号")
    private String record;
    private Date date;
    private Double doubleData;
}
