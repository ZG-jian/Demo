package com.jian.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {
    private int userid;

    @JsonProperty("name")
    private String username;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
