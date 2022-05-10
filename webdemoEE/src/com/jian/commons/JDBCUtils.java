package com.jian.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtils {
    private static  String URL;
    private static  String USER;
    private static  String PASSWORD;
    private static  String DRIVER;
    static {
        //读取properties文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        DRIVER = bundle.getString("DRIVER");
        URL = bundle.getString("URL");
        PASSWORD = bundle.getString("PASSWORD");
        USER = bundle.getString("USER");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取connection对象
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭connection
     */
    public static void closeCon(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeSta(Statement statement){
        if (statement!= null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void rollback(Connection conn){
        try {
            if (conn!=null) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }

