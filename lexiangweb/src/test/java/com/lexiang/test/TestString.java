package com.lexiang.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class TestString {

    @Test
    public void test(){
        String a = "{qweqwewq\"qqqq\"ss}";
        System.out.println(JSON.toJSONString(a));
        System.out.println(JSON.toJSONString(a).replaceAll("\\\\\"","\""));
    }
}
