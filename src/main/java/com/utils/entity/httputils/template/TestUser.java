package com.utils.entity.httputils.template;

import javax.xml.bind.annotation.XmlRootElement;

public class TestUser {
    String username;
    int password;

    public TestUser() {
    }

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

    public TestUser(String username, int password) {
        this.username = username;
        this.password = password;
    }
}
