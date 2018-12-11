package com.test.restcxfwebservice.impl;

import com.test.restcxfwebservice.TestRestCxfWebService;
import com.test.restcxfwebservice.TestUser;

import java.util.List;


public class TestRestCxfWebServiceImpl implements TestRestCxfWebService {
    public TestUser findById( int password) {
        TestUser testUser =new TestUser();
        testUser.setUsername("张三");
        testUser.setPassword(password);
        System.out.println("this is findById impl ====== ");
        System.out.println("this is password ====== :"+password);
        return testUser;
    }

    @Override
    public void saveTestUser(TestUser testUser) {

        System.out.println("this is saveTestUser impl ======");
        System.out.println("this is testUser  ====== :"+testUser);
    }

    @Override
    public void saveTestUser(TestUser testUser,String str) {

        System.out.println("this is saveTestUser2 impl ======");
        System.out.println("this is testUser2  ====== :"+testUser+"======str========"+str);
    }

    @Override
    public void saveTestUser(TestUser testUser, String str, String str2, int i, int i2) {
        System.out.println("this is saveTestUser3 method ======");
        System.out.println("this is testUser3  ====== :"+testUser+"======str========"+str);
        System.out.println("======str2========"+str2+"====i====="+i+"==i2==="+i2);
    }


    @Override
    public void deleteUser(Integer id) {
        System.out.println("this is deleteUser impl ======");
        System.out.println("this is id ====== : "+id);
    }

    @Override
    public void updateUser(TestUser testUser) {
        System.out.println("this is updateUser impl ======");
        System.out.println("this is testUser  ====== :"+testUser);
    }

    @Override
    public List<TestUser> findUserList() {
        System.out.println("this is findUserList impl ======");
        return null;
    }

    @Override
    public TestUser testPathParam(int password, String str) {
        System.out.println(password+"====="+str);
        return new TestUser(str,password);
    }
}