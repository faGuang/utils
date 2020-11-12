package com.yulecha.utils.excel.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.yulecha.utils.excel.ExcelDealWith;
import com.yulecha.utils.excel.dto.ExportDemoData;
import com.yulecha.utils.excel.dto.MatchingItemExcelDto;
import com.yulecha.utils.excel.dto.OpsExcelDto;
import com.yulecha.utils.excel.dto.YjshowVideoDto;
import com.yulecha.utils.util.BigDecimalUtils;
import com.yulecha.utils.util.StreamUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName：ExcelDealWith
 * @Description：
 * @Author：yulecha
 * @Date：2020/4/22 16:06
 * @Version 1.0
 **/
public class ExcelDealWithImpl implements ExcelDealWith {

    /**
     * excel 文件存放地址
     */
    private static String excelPath = "D:/dealExcel/";
    private static final String MAC_EXCEL_PATH = "/Users/mxx/softData/";

    @Test
    @Override
    public void dealYjshowVideoUpload() {
        // 读取 excel 表格的路径
        String readPath = excelPath + "KS2020H波段补.xlsx";

        try {
            // sheetNo --> 读取哪一个 表单
            // headLineMun --> 从哪一行开始读取( 不包括定义的这一行，比如 headLineMun为2 ，那么取出来的数据是从 第三行的数据开始读取 )
            // clazz --> 将读取的数据，转化成对应的实体，需要 extends BaseRowModel
            Sheet sheet = new Sheet(1, 1, YjshowVideoDto.class);

            // 这里 取出来的是 ExcelModel实体 的集合
            List<Object> readList = EasyExcelFactory.read(new FileInputStream(readPath), sheet);
            // 存 ExcelMode 实体的 集合
            List<YjshowVideoDto> list = new ArrayList<YjshowVideoDto>();
            for (Object obj : readList) {
                list.add((YjshowVideoDto) obj);
            }
            list.forEach(dto -> {
                String str = "INSERT INTO t_attachment(`filename`, `url`, `type`, `item1`, `item2`, `item3`, `catalog`, `catalog2`, `catalog3`, `brand`, `rank`, `isdelete`, `createuser`, `createdate`, `modifyuser`, `modifydate`, `videourl`, `item4`, `item5`, `item6`, `item7`, `item8`, `item9`, `item10`, `validdate`) " +
                        "VALUES ('" + dto.getName() + ".jpg', 'https://yjshow-fileserver.eeka.info/" + dto.getName() + ".jpg', " +
                        "'video', NULL, NULL, NULL, '" + dto.getCatalog1() + "', '" + dto.getCatalog2() + "', '" + dto.getCatalog3() + "', " +
                        "'" + dto.getBrand() + "', 0, 0, NULL, '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "', NULL, NULL, 'https://yjshow-fileserver.eeka.info/" + dto.getName() + ".mp4'," +
                        " NULL, NULL, NULL, NULL, NULL, NULL, NULL, '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "');";
                System.out.println(str);
            });
            System.out.println("》》》》》》》》》》》》》》》》总记录数：" + list.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Override
    public void countExcel() {
        // 读取 excel 表格的路径
//        String readPath = excelPath + "售后申请单报表-20200429000064.xlsx";
        String readPath = MAC_EXCEL_PATH + "门店数据导出.xlsx";

        try {
//            ReadSheet sheet = new ReadSheet(1);

//            Sheet sheet = new Sheet(1, 1, OpsExcelDto.class);

            // 这里 取出来的是 ExcelModel实体 的集合
            List<Object> readList = EasyExcel.read(new BufferedInputStream(new FileInputStream(readPath))).sheet(1).doReadSync();
//            List<Object> readList = EasyExcelFactory.read(new FileInputStream(readPath), sheet);
            // 存 ExcelMode 实体的 集合
            List<OpsExcelDto> list = new ArrayList<>();
            for (Object obj : readList) {
                list.add((OpsExcelDto) obj);
            }
            List<String> collect = list.stream()
                    .filter(dto -> StringUtils.isNoneBlank(dto.getNo()))
                    .filter(StreamUtils.distinctByKey(OpsExcelDto::getNo))
                    .map(OpsExcelDto::getNo)
                    .collect(Collectors.toList());
            System.out.println(">>>>>>>>>>>" + collect.size());
            System.out.println("》》》》》》》》》》》》》》》》总记录数：" + list.size());
            list.stream().forEach(dto -> {
                if (StringUtils.isBlank(dto.getNo())) {
                    System.out.println(dto.getNo());
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Override
    public void matchingSkc() {
        // 读取 excel 表格的路径
        String readPath = excelPath + "ddeal.xlsx";

        try {
            // sheetNo --> 读取哪一个 表单
            // headLineMun --> 从哪一行开始读取( 不包括定义的这一行，比如 headLineMun为2 ，那么取出来的数据是从 第三行的数据开始读取 )
            // clazz --> 将读取的数据，转化成对应的实体，需要 extends BaseRowModel
            Sheet sheet = new Sheet(1, 1, MatchingItemExcelDto.class);

            // 这里 取出来的是 ExcelModel实体 的集合
            List<Object> readList = EasyExcelFactory.read(new FileInputStream(readPath), sheet);
            // 存 ExcelMode 实体的 集合
            List<MatchingItemExcelDto> list = new ArrayList<MatchingItemExcelDto>();
            for (Object obj : readList) {
                list.add((MatchingItemExcelDto) obj);
            }

            // 匹配数据
            List<String> mubiao = new ArrayList<>();
            // 被匹配数据
            List<List<String>> yuanshuju = new ArrayList<>();

            for (MatchingItemExcelDto dto : list) {
                List<String> temp = new ArrayList<>();
                if (StringUtils.isNoneBlank(dto.getSoureceItem())) {
                    mubiao.add(dto.getSoureceItem());
                }
                if (StringUtils.isNoneBlank(dto.getTargetItem1())) {
                    temp.add(dto.getTargetItem1());
                }
                if (StringUtils.isNoneBlank(dto.getTargetItem2())) {
                    temp.add(dto.getTargetItem2());
                }
                if (StringUtils.isNoneBlank(dto.getTargetItem3())) {
                    temp.add(dto.getTargetItem3());
                }
                if (StringUtils.isNoneBlank(dto.getTargetItem4())) {
                    temp.add(dto.getTargetItem4());
                }
                yuanshuju.add(temp);
            }
            dealMatching(mubiao, yuanshuju);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Override
    public void dealImportExcel() {
        // 读取 excel 表格的路径
        String readPath = excelPath + "L2021春夏A1-A3款号(1).xlsx";

        try {
            // sheetNo --> 读取哪一个 表单
            // headLineMun --> 从哪一行开始读取( 不包括定义的这一行，比如 headLineMun为2 ，那么取出来的数据是从 第三行的数据开始读取 )
            // clazz --> 将读取的数据，转化成对应的实体，需要 extends BaseRowModel
            Sheet sheet = new Sheet(1, 1, MatchingItemExcelDto.class);

            // 这里 取出来的是 ExcelModel实体 的集合
            List<Object> readList = EasyExcelFactory.read(new FileInputStream(readPath), sheet);
            // 存 ExcelMode 实体的 集合
            List<MatchingItemExcelDto> list = new ArrayList<MatchingItemExcelDto>();
            for (Object obj : readList) {
                list.add((MatchingItemExcelDto) obj);
            }

            list.stream().forEach(dto -> {
                String target = dto.getTargetItem1();
                String[] split = target.split("\n");
                for (String fileName : split) {
                    System.out.print(fileName.split("：")[1] + "\t");
                }
                System.out.println();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dealMatching(List<String> mubiao, List<List<String>> yuanshuju) {
        System.out.println("计划部\t" + "商品部\t" + "匹配");
        for (String mb : mubiao) {
            HashSet strs = new HashSet();
            for (List<String> ysjs : yuanshuju) {
                boolean flag = true;
                for (String ysj : ysjs) {
                    if (flag && mb.equals(ysj)) {
                        flag = false;
                        strs.addAll(ysjs);
                    }
                }
            }
            strs.remove(mb);
            System.out.println(mb + "\t自在觉醒 A1\t" + strs.toString());
        }
    }

    private List<ExportDemoData> data() {
        List<ExportDemoData> list = new ArrayList<ExportDemoData>();
        for (int i = 0; i < 10; i++) {
            ExportDemoData data = new ExportDemoData();
            data.setString("字符串" + i);
            data.setNum(new BigDecimal("0"));
            list.add(data);
        }
        return list;
    }

    /**
     * 同步按模型读（默认读取sheet0,从第2行开始读）
     * @param filePath
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @return
     */
    public static List<T> syncReadModel(String filePath, Class clazz){
        return EasyExcelFactory.read(filePath).sheet().head(clazz).doReadSync();
    }
}
