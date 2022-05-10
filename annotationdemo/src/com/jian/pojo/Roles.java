package com.jian.pojo;

public class Roles {
    private int roleid;
    private String rolename;

    @Override
    public String toString() {
        return "Roles{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
