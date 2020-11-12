package com.yulecha.utils.test.impl;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.DmDialect;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yulecha.utils.excel.dto.ExportDemoData;
import com.yulecha.utils.test.CodeTest;
import com.yulecha.utils.test.dto.DemoData;
import com.yulecha.utils.test.dto.OverrideEquals;
import com.yulecha.utils.util.BigDecimalUtils;
import com.yulecha.utils.util.EasyExcelUtil;
import lombok.*;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
//        LocalDateTime of1 = LocalDateTime.of(2020, 10, 11, 16, 22, 50);
//        LocalDateTime of2 = LocalDateTime.of(2020, 10, 11, 16, 22, 49);
//        LocalDateTime of3 = LocalDateTime.of(2020, 10, 11, 16, 22, 51);
//        List<LocalDateTime> time = new ArrayList<>();
//        time.add(of1);
//        time.add(of2);
//        time.add(of3);
//        time.stream().sorted()
        HashMap<String, String> hashMap = new HashMap<>();
        System.out.println(hashMap.get(null));

        List<Long> ids = new ArrayList<>();
        ids.add(0L);
    }

    @Data
    class H {
        private Integer a;
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
//        Optional<LocalDateTime> any = times.stream().sorted(Comparator.reverseOrder()).findFirst();
//        System.out.println(any.get());
        List<LocalDateTime> collect = times.stream().sorted().collect(Collectors.toList());
        System.out.println(collect.get(0));
        System.out.println(collect.get(collect.size()-1));
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

    @Test
    @Override
    public void testBigDecimalUtils() {
        BigDecimal bigDecimal1 = new BigDecimal("0.122");
        BigDecimal bigDecimal2 = new BigDecimal("0.233");
        BigDecimal bigDecimal = BigDecimalUtils.subtract(BigDecimal.ONE, bigDecimal2);
        System.out.println(bigDecimal);
    }

    @Override
    public void testConditonUtil() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("abc", "");
    }

    @Test
    @Override
    public void testObject2JSON() {
        StoreData build = StoreData.builder().code("1").value("2").build();

        String fileName = JSONUtil.parse(build).toString();

        System.out.println(fileName);

        StoreData storeData = JSONUtil.toBean("{\"code\":\"1\",\"value\":\"2\"}", StoreData.class);
        System.out.println(storeData.getCode());
    }

    @Test
    @Override
    public void subStringTest() {
        String str = "";
        System.out.println(str.substring(0, str.length() -1 ));
    }

    @Test
    @Override
    public void strSplit() {
        String str = "2936,2935,2934,2933,2932,2931,2930,2929,2928,2927,2924,2921,2918,2917,2916,2915,2911,2909,2907,2906,2905,2904,2903,2902,2901,2900,2899,2897,2892,2889,2888,2887,2886,2885,2884,2883,2882,3237,3236,3235,3234,3233,3232,3229,3228,3226,3225,3224,3223,3222,G092,3221,3218,2476,3216,3215,3214,3213,3210,3209,3207,1169,3206,3205,3204,3203,3200,3199,2474,3198,3196,3191,3190,3189,3187,3186,3185,3180,3178,3177,3176,3175,3170,3169,3167,3164,3163,3162,3161,3160,3158,2881,2880,2879,2878,2877,2875,2874,2872,2871,2870,2869,2893,2926,2868,2866,2862,2860,2859,2853,2795,2852,2845,2844,2842,2840,2839,2837,2891,2836,2835,2833,2832,2830,2470,2829,2828,2827,2825,2822,2821,2819,2818,2817,2816,2815,2809,2793,2792,2791,2790,2789,2785,2784,2781,2780,2779,2468,2778,2771,2769,2766,2765,2764,2890,2672,2669,2667,1001,2665,2664,2662,2661,2660,2659,2658,2657,2656,2655,2653,2652,2650,2649,2648,2647,2645,2644,2641,2640,2637,2635,2634,2633,2631,2630,2628,2627,2812,2626,2625,2624,2782,2579,2623,2622,2620,2619,2618,2617,2616,2615,2613,2612,2611,2610,2530,2467,2607,2606,2604,2593,2969,2965,2964,2963,2962,2591,2590,2588,2587,2586,2584,2578,2562,2560,2867,2558,2557,2556,2555,2554,2553,2858,2548,2546,2545,2542,2541,2533,2306,2848,2458,2457,2456,2455,2454,2453,2451,1101,2450,2449,2448,2446,3023,2445,2444,2441,2440,2439,2438,2437,2436,2435,2434,2433,2432,2431,1095,2429,2428,2427,2426,2424,2423,1094,1085,2421,2420,2419,2418,2193,2192,2191,2190,2189,2188,2847,2187,2186,2185,2184,2183,2182,2181,2180,2179,2178,2773,2177,2176,2175,2174,1071,1070,2173,2172,2171,2170,2169,2094,2168,2167,2166,2165,2164,2857,2163,2162,2161,2160,2159,2158,2157,2156,2155,2154,2153,2152,2151,2150,2149,2148,2147,2146,2145,2144,2763,2762,2761,2760,2759,2758,2757,2783,2756,2755,2753,2750,2749,2742,2740,2739,2736,2735,2733,2732,2731,2730,2728,2727,2726,2724,2717,2716,2715,2712,2711,2710,2709,2708,2707,2704,2703,2702,2701,2700,2699,2698,2692,2691,2688,2687,2686,2685,2684,2683,2682,2681,2680,2679,2676,2675,2674,2673,G104,2143,2142,2141,2140,2139,2138,2137,2136,2135,3079,1068,1067,2134,2133,2132,2131,2130,2129,2128,2127,2125,2124,2123,2122,2121,2120,2119,3051,2118,2115,2114,2112,2111,2110,2109,2108,2107,2106,2105,2104,2103,2102,2101,1092,2100,2099,2098,2097,2095,2092,2089,2088,2087,1066,2086,2085,2084,2083,2081,2080,2078,2077,2076,2075,1930,1929,1927,1057,2838,1926,1925,1924,1091,1923,1922,1921,1920,1919,1918,1916,1914,1055,1913,1090,1912,1911,1910,1909,1908,1907,1906,1905,1904,1903,1902,1901,1900,1899,1898,1897,1896,1893,1892,1890,1889,1888,1887,1886,1885,1884,1054,1053,1883,1881,1880,1878,1877,1876,1875,1874,2355,2354,2351,2349,2090,1093,2342,2340,2337,2334,2331,2330,1081,2329,2328,2668,2322,2321,2316,2314,2311,2308,2304,2302,2299,2298,2284,2276,2275,2274,2272,1080,1079,2270,2269,2268,2055,2267,2266,2265,2264,2263,2262,2261,2259,2257,2256,2255,2254,2253,2252,2251,2250,2249,2248,2247,2246,1078,1077,2245,2244,2243,2242,2241,2239,2238,2237,2236,2235,2234,2233,1076,2232,2228,2227,2226,2225,2224,2222,2221,2220,2219,2218,2217,1075,2216,2215,2214,2213,2212,2211,2210,2209,2208,2207,2203,2202,3217,1072,2201,2200,2199,2197,2195,2194,1872,1871,1870,1869,1052,1867,1866,1865,1864,1862,1861,1858,1857,1855,1853,1852,1851,2813,2287,1850,1826,1825,1824,1823,1822,1821,1818,1817,1815,1814,1813,1812,1811,1810,1809,1807,1806,1805,1804,1803,1802,1801,1800,1797,1796,1795,1793,1792,1791,1051,1789,1788,1787,1786,1785,1784,1782,1781,1780,1779,1778,1777,1775,1774,1688,1687,1686,1045,1088,1087,1684,1683,1682,1681,1680,1679,1678,1677,1676,1674,1673,1672,1671,1044,1670,1669,1668,1667,1666,1665,1664,1663,1662,1661,1660,1659,1658,1657,1656,1655,1654,1653,1652,1651,1650,1649,1648,1647,1646,1645,1644,1643,1642,1641,1639,1638,1637,1636,1635,1634,2417,2416,2223,2415,2412,2411,2410,2409,2408,2407,2406,2405,2403,2402,2401,2395,2393,2386,2383,2373,2372,2370,2367,1084,1083,2364,2356,2074,2073,2072,2071,1065,1873,2069,2068,2067,2066,2065,2064,2063,2062,2061,1064,2059,2058,2057,2056,2054,2053,2052,2051,2050,1063,1062,2049,2048,2047,2040,2039,2038,2037,2036,2035,2034,2033,2031,2029,2028,2027,2026,2025,2024,2023,2022,2021,2020,2019,2018,2017,2016,2015,2014,2013,2012,2011,2010,2009,1061,2846,2008,2007,2006,2004,2003,2002,2861,2001,2000,1999,1998,1996,1995,1994,1992,1991,1990,1989,2841,1060,1988,1987,1985,1984,1983,1982,1981,1980,1979,1978,1977,1976,2820,1975,1974,1973,1972,1971,1970,1965,1964,1963,1962,1961,1960,1058,1959,1958,1957,1956,1955,1954,1953,1952,1949,1948,1947,1946,2808,1945,1944,1943,1942,1941,2605,1940,1937,1936,1935,1934,1933,1932,1931,1633,1632,1631,1630,1629,1628,1627,1626,1625,1624,1623,2910,1622,1620,1619,2856,1617,1616,1615,1614,2855,1613,1612,1611,1610,1609,1608,1607,1606,1605,1604,1603,1602,1601,1618,1600,1599,1598,2327,1597,1596,1595,1594,1593,1592,1591,1590,1589,1588,1587,1586,1585,1584,1043,1583,1581,1580,1578,1577,1575,1574,1573,1572,1571,1509,1040,1508,1507,1505,1503,1502,1501,1499,1498,1497,1496,1495,1494,1493,1038,1491,1490,1489,1488,1487,1486,1485,1484,1483,1482,1481,1480,1478,1475,1474,1473,1472,1471,1470,1469,1468,1467,1466,1464,1463,1462,1037,1036,1461,1459,1457,1456,1455,1454,1453,1451,1450,1449,1448,1447,2046,2045,2044,2042,2041,1773,1772,1771,1770,1769,1768,1767,1766,1560,1764,1759,1763,1762,1761,1760,1758,2511,1050,1757,1756,1755,1754,1753,1752,1751,1750,1749,1748,1049,1048,1747,1746,1745,1744,1742,1741,1740,1739,1738,1737,1736,1735,1734,1733,1731,1730,1729,1728,1727,1726,1725,1724,1723,1721,1720,1719,1047,1046,1718,1717,1716,1714,1894,1917,1712,1711,1710,1709,1708,1707,1706,1705,1704,2430,1703,1701,1700,1699,1698,1697,1695,1694,2093,1691,1690,1689,1446,1445,1443,2070,1442,1441,1439,1438,1437,1436,1435,1434,1433,1432,1431,1086,1430,1429,1428,1426,1425,1423,1422,1421,1420,1419,1418,1417,1035,1034,1506,1416,1415,1414,1413,1412,1410,1409,1408,1406,1405,1404,1403,1402,1401,1400,1398,1397,1396,1395,1394,1393,1392,1391,1390,1388,1387,1386,1385,1384,1383,1382,1381,1380,1148,1147,1146,2804,1145,1743,1144,1142,1018,1141,1140,1138,1137,1136,1135,2814,1134,1133,1132,1131,1130,1128,1126,1125,1123,1122,1121,1120,1119,1118,1117,1116,1115,1114,1113,1112,1111,1110,1109,1108,1106,1104,1103,1102,1006,1100,1099,1005,1004,1098,1097,1003,1096,1016,1059,1015,1570,1569,1568,1567,2206,1477,1566,1565,1564,1562,1561,1559,1558,1557,1556,1555,1554,1553,1552,1551,2851,1550,1549,1548,1546,1545,2806,1544,1543,2854,1542,1541,1540,1539,1538,1537,1042,1536,1535,1532,1531,1530,1526,1525,1524,1523,1522,1521,1520,1041,1266,1519,1518,1517,1516,1515,1514,1513,1512,1511,1510,1013,2925,1011,1014,2796,2980,2335,2979,2005,2978,1722,2770,1790,2977,1966,2949,2923,1127,2849,2803,2801,2914,2834,2981,1002,1008,1799,1379,1377,1372,1371,1370,1369,1368,1367,1366,1365,1364,1363,1033,1032,1362,1361,1357,1356,1355,1354,1353,1352,1351,1350,1030,1029,1349,1348,1347,1345,2786,1342,1341,1028,1027,1326,1325,1324,1928,1323,1322,1321,1320,1319,1318,1317,1294,1284,1283,1282,1281,1280,1279,1272,1271,1270,1269,1268,1267,1265,1264,2805,1023,1261,1260,1259,1258,1257,1256,1255,1254,1253,1250,1249,1248,1247,1246,1022,1244,1243,1242,1241,1240,1239,1238,1237,1236,1235,1234,1233,1232,1231,1794,1230,1229,1227,1226,1225,1224,1223,1222,1221,1220,1219,1218,1217,1215,1214,1213,1210,1209,1208,1207,1206,1205,1204,1203,1202,1021,1020,1019,1201,1200,1199,1198,1197,1196,1194,1192,1191,1190,1189,1188,1187,1186,1185,1184,1183,1182,1181,1180,1178,1177,1176,1175,1174,1173,1172,1171,1168,1167,1165,1164,1163,1162,1160,1159,1158,1157,1156,1155,1153,1152,1151,1150,1149";
        List<String> list = Arrays.asList(str.split(","));
        for (int i = 0; i < list.size()/5; i++) {
            String stores = list.stream()
                    .skip(i * 5)
                    .limit(5).collect(Collectors.joining(","));
            System.out.println(stores);
            if (i == 1) {
                continue;
            }
            System.out.println("=========");
        }
    }

    @Test
    @Override
    public void testAnnotation() {
        try {
            Method[] methods = TestMethodAnnotation.class.getClassLoader()
                    .loadClass("com.yulecha.utils.test.impl.TestMethodAnnotation")
                    .getMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                    for (Annotation anno : method.getDeclaredAnnotations()) {
                        System.out.println("Annotation in Method '" + method + "' : " + anno);
                    }
                    MyMethodAnnotation methodAnno = method.getAnnotation(MyMethodAnnotation.class);

                    System.out.println(methodAnno.title());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Override
    public void randomNumber() {
        Random random = new Random();

        System.out.println(random.nextInt(999999));

//        for (int i = 0; i < 400; i++) {
//            int number = random.nextInt(999999);
//            System.out.println("INSERT INTO \"public\".\"sc_logistics_proof\"(\"id\", \"logistics_proof_code\", \"logistics_company_name\", " +
//                    "\"logistics_no\", \"status\", \"tenant_id\", \"app_id\", \"deleted\", \"create_user_id\", \"create_user_name\", " +
//                    "\"create_time\", \"modify_user_id\", \"modify_user_name\", \"modify_time\", \"sources_no\", \"logistics_company_code\", " +
//                    "\"logistics_code\", \"deliverer_name\", \"deliverer_phone\", \"logistics_receiver_info\", \"sources_no_type\", " +
//                    "\"notice_record_code\") VALUES (7507151095"+ number +", 'WL20191224"+ number +"', '京东', '444019374899', 10, 1, NULL, 'f', NULL, NULL, " +
//                    "'2019-12-24 09:03:39.071', NULL, NULL, '2019-12-24 09:03:39.071', '3729832721095069696', 'JD', '103', NULL, NULL, NULL, NULL, 'DON20200902000100');");
//        }

    }


    @Test
    @Override
    public void countTime() {
        LocalDateTime startTime = LocalDateTime.of(2020, 9, 10, 00, 00, 00);
        LocalDateTime endTime = LocalDateTime.of(2020, 9, 13, 23, 59, 59);
        int dayGap = (int) ChronoUnit.HOURS.between(startTime, endTime);
        System.out.println(dayGap);
        System.out.println(dayGap/24);
    }

    @Test
    @Override
    public void listContain() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("a", 1);
        map.put("v", 1);
        System.out.println(map.size());
        List<String> list = Arrays.asList("a", "b", "c", "a");
        System.out.println(list.contains("t"));
    }

    @Test
    @Override
    public void StringBufferDelete() {
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("123");
//        String ss = stringBuffer.toString();
//        if (StringUtils.isNotBlank(ss)) {
//            System.out.println("不为空");
//        }

        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        List<String> list = Arrays.asList("a", "b");
        list = list.stream().filter(dto -> !map.containsKey(dto)).collect(Collectors.toList());
        System.out.println(list.toString());


        String orderNo = "";
        for (String s : orderNo.split(",")) {
            System.out.println(s);
        }
    }

    @Test
    @Override
    public void testExport() {
        // 写法1
        String fileName = "D:/dealExcel/hh.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        DemoData demoData = new DemoData();
        demoData.setRecord("123123");
        List<DemoData> data = Arrays.asList(demoData);
//        data.stream().forEach(dto -> {
            try {
                Class<?> clazz = Class.forName("DemoData");
                Field field = clazz.getDeclaredField("record");
                ExcelProperty excelProperty = field.getAnnotation(ExcelProperty.class);
                InvocationHandler h = Proxy.getInvocationHandler(excelProperty);
                Field hField = h.getClass().getDeclaredField("memberValues");
                hField.setAccessible(true);
                Map<Object, Object> memberValues = (Map)hField.get(h);
                String[] excelPropertyValue = {"加加加"};
                memberValues.put("value", excelPropertyValue);
//                excelProperty.value();
                System.out.println("啊哈哈");
                System.out.println(excelProperty.value());
            } catch (Exception e) {

            }
//        });

        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data);

        // 写法2
//        fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
//        ExcelWriter excelWriter = null;
//        try {
//            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
//            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//            excelWriter.write(null, writeSheet);
//        } finally {
//            // 千万别忘记finish 会帮忙关闭流
//            if (excelWriter != null) {
//                excelWriter.finish();
//            }
//        }
    }


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyMethodAnnotation {
        public String title() default "";
        public String description() default "";
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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class StoreData {
    private String code;

    private String value;
}
