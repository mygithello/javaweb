package com.test.restcxfwebservice;

import javax.xml.bind.annotation.XmlRootElement;


//指定序列化（转换XML、JSON） 对象名字
//@XmlRootElement//默认是testUser//该注解表示以testUser 为 返回的json数据的key
//@XmlRootElement(name="user")
@XmlRootElement()
public class TestUser {
    String username;
    int password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "username='" + username + '\'' +
                ", password=" + password +
                '}';
    }

    public TestUser(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public TestUser() {
    }
}
