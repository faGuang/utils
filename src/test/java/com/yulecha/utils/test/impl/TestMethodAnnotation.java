package com.yulecha.utils.test.impl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName：Testaaa
 * @Description：
 * @Author：MaRui
 * @Date：2020/8/25 8:14
 * @Version 1.0
 **/
public class TestMethodAnnotation {

    @Override
    @CodeTestImpl.MyMethodAnnotation(title = "toStringMethod", description = "override toString method")
    public String toString() {
        return "Overirde toString method";
    }

    @Deprecated
    @CodeTestImpl.MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public void oldMethod() {
        System.out.println("old method, don't use it");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @CodeTestImpl.MyMethodAnnotation(title = "test method", description = "suppress warning static method")
    public void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }
}
