package com.bjsxt.pojo;

import java.util.List;

public class Menu {
    private Integer mmid;
    private String mname;
    private String url;
    private  int pid;
    private List<Menu> list;

    public Integer getMmid() {
        return mmid;
    }

    public void setMmid(Integer mmid) {
        this.mmid = mmid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    public Menu() {
    }

    public Menu(Integer mmid, String mname, String url, int pid) {
        this.mmid = mmid;
        this.mname = mname;
        this.url = url;
        this.pid = pid;
    }
}
