package com.yulecha.utils.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName：DateUtils
 * @Description：
 * @Author：yulecha
 * @Date：2020/5/16 16:33
 * @Version 1.0
 **/
public class DateUtils {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDDHH = "yyyyMMddHH";

    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * localDateTime 时间格式化为 字符串
     * @param time
     * @return
     */
    public static String localDateTime2Str(LocalDateTime time) {
        if (null == time) {
            return "";
        }
        return df.format(time);
    }
}
