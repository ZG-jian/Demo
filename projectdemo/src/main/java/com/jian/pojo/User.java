package com.jian.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer tId;

    private String tPost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettPost() {
        return tPost;
    }

    public void settPost(String tPost) {
        this.tPost = tPost == null ? null : tPost.trim();
    }
}