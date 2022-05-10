package com.jian.pojo;

import java.io.Serializable;

public class Users implements Serializable {
    private int userid;
    private String username;
    private String usersex;

    public Users(int userid, String username, String usersex) {
        this.userid = userid;
        this.username = username;
        this.usersex = usersex;
    }

    public Users() {
    }


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

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                '}';
    }
}
