package com.yulecha.utils.test.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName：Person
 * @Description：
 * @Author：yulecha
 * @Date：2020/4/28 18:51
 * @Version 1.0
 **/
@Data
@Builder
public class Person {
    private Integer id;
    private String name;
}
