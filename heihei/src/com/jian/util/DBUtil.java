package com.jian.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
  private static String url = "";
  private static String user = "";
  private static String password = "";
  
  static  {
    Properties ppt = new Properties();
    InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
    try {
      ppt.load(is);
      url = ppt.getProperty("url");
      user = ppt.getProperty("user");
      password = ppt.getProperty("password");
    } catch (IOException e) {
      e.printStackTrace();
    } 
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } 
  }

  /**
   * 尽可能晚的连接数据库
   * 用于链接数据库，得到的结果是数据库的连接对象，链接对象具备了操作数据库的很多功能
   * @return 链接对象
   */
  public static Connection getConn() {
    try {
      Connection conn = DriverManager.getConnection(url, user, password);
      return conn;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } 
  }

  /**
   * 尽可能早的断开数据库连接
   * 因为数据库的连接句柄数是有限的，占满了就没法再连接了
   * 所以及时的释放是走作为一个程序员良好的编码习惯
   *断开数据库资源的链接，用于释放资源
   * @param conn  要释放的链接
   * @param statement 要释放的执行环境
   * @param resultSet 要释放的结果集
   */
  public static void close(Connection conn, Statement statement, ResultSet resultSet) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } 
    }
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } 
    }
    if (resultSet != null)
      try {
        resultSet.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }  
  }
}
