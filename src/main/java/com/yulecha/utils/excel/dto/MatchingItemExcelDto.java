package com.yulecha.utils.excel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @ClassName：MatchingItemExcelDto
 * @Description：
 * @Author：yulecha
 * @Date：2020/3/18 11:03
 * @Version 1.0
 **/
public class MatchingItemExcelDto extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String soureceItem;

    @ExcelProperty(index = 1)
    private String targetItem1;

    @ExcelProperty(index = 2)
    private String targetItem2;

    @ExcelProperty(index = 3)
    private String targetItem3;

    @ExcelProperty(index = 4)
    private String targetItem4;

    public String getSoureceItem() {
        return soureceItem;
    }

    public void setSoureceItem(String soureceItem) {
        this.soureceItem = soureceItem;
    }

    public String getTargetItem1() {
        return targetItem1;
    }

    public void setTargetItem1(String targetItem1) {
        this.targetItem1 = targetItem1;
    }

    public String getTargetItem2() {
        return targetItem2;
    }

    public void setTargetItem2(String targetItem2) {
        this.targetItem2 = targetItem2;
    }

    public String getTargetItem3() {
        return targetItem3;
    }

    public void setTargetItem3(String targetItem3) {
        this.targetItem3 = targetItem3;
    }

    public String getTargetItem4() {
        return targetItem4;
    }

    public void setTargetItem4(String targetItem4) {
        this.targetItem4 = targetItem4;
    }
}
