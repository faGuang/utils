package com.yulecha.utils.test.impl;

import com.yulecha.utils.test.CodeTest;
import com.yulecha.utils.test.dto.Person;
import com.yulecha.utils.util.BigDecimalUtils;
import net.sf.jsqlparser.statement.select.Skip;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName：CodeTestImpl
 * @Description：简单的代码测试
 * @Author：yulecha
 * @Date：2020/4/22 11:45
 * @Version 1.0
 **/
public class CodeTestImpl implements CodeTest {

    @Test
    @Override
    public void Hello() {
        System.out.println("Hello World");
    }

    @Override
    public void excelRead() {

    }

    @Test
    @Override
    public void LocaDateComputeTest() {
        LocalDate startTime = null;
        LocalDate endTime = null;
        startTime = LocalDate.parse("2020-02-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        endTime = LocalDate.parse("2020-03-06", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(startTime.until(endTime, ChronoUnit.DAYS));

        HashMap<String, Object> params = new HashMap<>();
        while (startTime.until(endTime, ChronoUnit.DAYS) > 0) {
            params.put("startTime", startTime);
            if (startTime.until(endTime, ChronoUnit.DAYS) > 10) {
                params.put("endTime", startTime.plusDays(10));
                startTime = startTime.plusDays(10);
            } else {
                params.put("endTime", endTime);
                startTime = endTime;
            }

            System.out.println(params);
        }
    }

    @Test
    @Override
    public void TestEnum() {
        List<String> list = Arrays.asList("1","1","1","1","1","6");
        list.stream().distinct().forEach(System.out::println);
    }

    public static volatile long now;

    @Test
    @Override
    public void test() {
        System.out.println("12344444".substring(1, 2));
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime minus = now.minusDays(5);
//        System.out.println(minus);
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("ScheduledTask");
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    @Test
    @Override
    public void testBigFormater() {
//        BigDecimal bigDecimal = new BigDecimal("8");
//        System.out.println(Objects.equals(bigDecimal, BigDecimal.ZERO));
//        System.out.println(BigDecimalUtils.isNotZero(new BigDecimal("22")));
//        System.out.println(BigDecimalUtils.isNotZero(new BigDecimal("0")));
//        System.out.println(BigDecimalUtils.isNotZero(null));
        System.out.println(BigDecimalUtils.customFormattedDecimalToPercentage(new BigDecimal("0.3455"), 1));
    }

    @Test
    @Override
    public void dateFormater() {
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    }

    @Test
    @Override
    public void dateSort() {
        List<LocalDateTime> times = Arrays.asList(LocalDateTime.of(2009, 2, 23, 14, 50),
                LocalDateTime.of(2008, 2, 23, 14, 50),
                LocalDateTime.of(2010, 2, 23, 14, 50),
                LocalDateTime.of(2022, 2, 23, 14, 50));
        Optional<LocalDateTime> any = times.stream().sorted(Comparator.reverseOrder()).findFirst();
        System.out.println(any.get());
    }

    @Test
    @Override
    public void testOptionalOrElse() {
        List<String> strs = null;
//        strs.add("哈哈");
        List<String> list = Optional.ofNullable(strs).orElse(Arrays.asList("嘻嘻"));
        System.out.println(list.size());
        System.out.println(list.toString());
    }

    @Test
    @Override
    public void testMapContainKey() {
        Map<String, String> maps = new HashMap<>();
        System.out.println(maps.containsKey(null));
    }

    @Test
    @Override
    public void stringEndwithTest() {
        String fileName = "hha.xlsx";
        System.out.println(fileName.endsWith("xlsx"));
    }

    public enum  ssEnum{
        A("1", "1"),
        B("1", "1");

        private String code;
        private String msg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        ssEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}

class storeData {
    private String code;

    private Integer value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
