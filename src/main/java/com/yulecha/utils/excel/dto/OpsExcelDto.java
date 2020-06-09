package com.yulecha.utils.excel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @ClassName：OpsExcelDto
 * @Description：
 * @Author：yulecha
 * @Date：2020/4/23 14:55
 * @Version 1.0
 **/
@Data
public class OpsExcelDto {

    @ExcelProperty(index = 0)
    private String no;
}
