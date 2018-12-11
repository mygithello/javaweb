package com.test.webservice.impl;

import com.test.webservice.TestService;

import javax.jws.WebService;
@WebService
public class TestServiceImpl implements TestService {

    @Override
    public void login() {
        System.out.println("this is a test!!--调用到了服务端的方法");
    }
}
