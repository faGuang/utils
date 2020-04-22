package com.yulecha.utils.test.impl;

import com.yulecha.utils.test.CodeTest;
import org.junit.Test;

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
}
