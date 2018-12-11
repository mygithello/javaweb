package com.test.springcxfwebservice.impl;

import com.test.springcxfwebservice.TestCxfWebService;

public class TestCxfWebServiceImpl  implements TestCxfWebService{
    @Override
    public String  testMethod() {
        String string="张三";
        System.out.println("this is service ");
        System.out.println("发布");
        return string;
    }
}
