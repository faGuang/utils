package com.yulecha.utils.util;

import com.yulecha.utils.annotation.IsZeroConvertNull;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Objects;

/**
 * @ClassName：BigDecimalUtils
 * @Description：BigDecimal 处理相关工具类
 * @Author：yulecha
 * @Date：2020/5/16 16:26
 * @Version 1.0
 **/
@Slf4j
public class BigDecimalUtils {

    // 百分数精确度
    private static final Integer PRECISION_1 = 1;

    private static final Integer PRECISION_2 = 2;

    /**
     * 百分比格式化（百分数精确度为 2，即保留两位小数）
     * @param bigDecimal 0.34015
     * @return 34.02%
     */
    public static String formattedDecimalToPercentage(BigDecimal bigDecimal) {
        if (null == bigDecimal) {
            return "";
        }
        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(PRECISION_2);

        return nt.format(bigDecimal);
    }

    /**
     * 自定义百分比格式化精确度
     * @param bigDecimal
     * @return
     */
    public static String customFormattedDecimalToPercentage(BigDecimal bigDecimal, Integer precision) {
        if (null == bigDecimal) {
            return "";
        }
        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(precision);

        return nt.format(bigDecimal);
    }

    /**
     * 是否为0,
     * @param bigDecimal 0
     * @return true
     */
    public static boolean isZero(BigDecimal bigDecimal) {
        if (null == bigDecimal || BigDecimal.ZERO.compareTo(bigDecimal) == 0) {
            return true;
        }

        return false;
    }

    /**
     * 不为 0
     * @param bigDecimal
     * @return
     */
    public static boolean isNotZero(BigDecimal bigDecimal) {
        if (null != bigDecimal && BigDecimal.ZERO.compareTo(bigDecimal) != 0) {
            return true;
        }

        return false;
    }

    /**
     * 需配合 IsNullConvertZero（自定义） 注解使用，在实体类中字段上加
     * @param obj
     * @return
     */
    public static Object null2Zero(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            // 获得私有的成员属性
            Field[] fields = clazz.getDeclaredFields();
            if(Objects.nonNull(fields) && fields.length>0){
                for(Field field : fields){
                    field.setAccessible(true);
                    // 判断 IsNullConvertZero 注解是否存在
                    if(field.isAnnotationPresent(IsZeroConvertNull.class)){
                        if(BigDecimal.ZERO.compareTo((BigDecimal) field.get(obj)) == 0){
                            field.set(obj, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("BigDecimalUtils.null2Zero：{}",e);
        }

        return obj;
    }
}
