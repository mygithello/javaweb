package com.test.webservice.test;

import com.test.webservice.impl.TestServiceImpl;

import javax.xml.ws.Endpoint;

public class CreateWsdl {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8082/TestServiceImplss", new TestServiceImpl());
        System.out.println("发布");
    }
}
