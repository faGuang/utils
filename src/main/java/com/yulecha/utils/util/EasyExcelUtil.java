package com.yulecha.utils.util;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * @ClassName：EasyExcelUtils
 * @Description：
 * @Author：MaRui
 * @Date：2020/7/1 11:33
 * @Version 1.0
 **/
@Slf4j
@Component
public class EasyExcelUtil {

    /**
     * excel 导出工具类
     * @param cls
     * @param data
     * @param filename
     * @param response
     */
    public void exportExcel(Class cls, List<?> data, String filename, HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        try {
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8") + ".xlsx");
            EasyExcel.write(response.getOutputStream(), cls).sheet(filename).doWrite(data);
        } catch (Exception e) {
            log.error(filename + "，导出失败");
            e.printStackTrace();
        }
    }

    /**
     * 不指定导出后excel表文件名（前后端分离，前端会自己命名）
     * @param cls
     * @param data
     * @param response
     */
    public void exportExcel(Class cls, List<T> data, HttpServletResponse response) {
        exportExcel(cls, data, "模板", response);
    }
}
