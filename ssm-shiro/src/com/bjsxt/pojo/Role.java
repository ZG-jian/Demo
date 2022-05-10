package com.bjsxt.pojo;

import java.io.Serializable;

public class Role implements Serializable {
    private int rid;
    private String rname;

    public Role() {
    }

    public Role(int rid, String rname) {
        this.rid = rid;
        this.rname = rname;
    }

    public int getRid() {
        return rid;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                '}';
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
