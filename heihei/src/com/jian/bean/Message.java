package com.jian.bean;

import com.alibaba.fastjson.JSON;

public class Message {
    private Object data;
    private String msg;
    private int status;

    public void setData(Object data) {
        this.data = data;
    }


    public Object getData() {
        return this.data;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getMsg() {
        return this.msg;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    public int getStatus() {
        return this.status;
    }

  /**
   * 将java中抽象的消息对象转换为JSON格式的字符串
   * @return
   */
    public String toJSON() {
        return JSON.toJSONString(this);
    }
}
