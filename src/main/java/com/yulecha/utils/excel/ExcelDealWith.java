package com.yulecha.utils.excel;

import java.io.FileNotFoundException;

/**
 * @ClassName：ExcelDealWith
 * @Description：
 * @Author：yulecha
 * @Date：2020/4/22 16:03
 * @Version 1.0
 **/
public interface ExcelDealWith {

    /**
     * 处理魅力秀视频上传（读取 excel 表输出插入 sql 语句）
     */
    void dealYjshowVideoUpload();

    /**
     * 统计报表中不重复数据数量
     */
    void countExcel();

    /**
     * 根据要求 skc 匹配搭配款
     */
    void matchingSkc();

    /**
     * 根据原excel表处理款号
     */
    void dealImportExcel();


    void exportExcel();

    /**
     * easyExcel 无实体类导入测试
     */
    void importTest() throws FileNotFoundException;
}
