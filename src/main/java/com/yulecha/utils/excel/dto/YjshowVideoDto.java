package com.yulecha.utils.excel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @ClassName：YjshowVideoDto
 * @Description：
 * @Author：yulecha
 * @Date：2020/4/22 16:08
 * @Version 1.0
 **/
@Data
public class YjshowVideoDto extends BaseRowModel {

    @ExcelProperty(value = "图片、视频名字", index = 0)
    private String name;

    @ExcelProperty(value = "一级目录", index = 2)
    private String catalog1;

    @ExcelProperty(value = "二级目录", index = 3)
    private String catalog2;

    @ExcelProperty(value = "三级目录", index = 4)
    private String catalog3;

    @ExcelProperty(value = "所属品牌", index = 5)
    private String brand;
}
