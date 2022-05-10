package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.List;

public class Admin implements Serializable {
    private String username;
    private String password;
    private String salt;
    private int rid;
    //保存菜单的集合
    private List<Menu> list;
    //保存权限的集合--因为这里一个用户对应一个权限，就不用集合
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
