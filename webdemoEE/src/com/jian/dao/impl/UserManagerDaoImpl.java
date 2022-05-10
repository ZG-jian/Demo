package com.jian.dao.impl;

import com.jian.commons.JDBCUtils;
import com.jian.dao.UserManagerDao;
import com.jian.pojo.Users;
import jdk.nashorn.internal.ir.WhileNode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理持久层
 */
public class UserManagerDaoImpl implements UserManagerDao {
    @Override
    public void insertUser(Users users) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);//关闭事务自动提交
            PreparedStatement ps = conn.prepareStatement("insert into users values(default ,?,?,?,?,?)");
            ps.setString(1,users.getUsername());
            ps.setString(2,users.getUserpwd());
            ps.setString(3,users.getUsersex());
            ps.setString(4,users.getPhonenumber());
            ps.setString(5,users.getQqnumber());
            ps.execute();
            conn.commit();//事务提交
        }catch (Exception e){
            e.printStackTrace();//开发阶段可以打印
            JDBCUtils.rollback(conn);
        }finally {
            JDBCUtils.closeCon(conn);
        }
    }

    /**
     * 查询用户
     * @param users
     * @return
     */
    @Override
    public List<Users> selectUserByProperties(Users users) {
        Connection conn = null;
        List<Users> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql = this.createSql(users);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Users user = new Users();
                user.setUserid(resultSet.getInt("userid"));
                user.setUsersex(resultSet.getString("usersex"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpwd(resultSet.getString("userpwd"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
                user.setQqnumber(resultSet.getString("qqnumber"));
                list.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();//开发阶段可以打印,到时候上线再删除掉就就行
        }finally {
            JDBCUtils.closeCon(conn);
        }
        return list;
    }

    /**
     * 根据用户ID查询用户
     * @param userid
     * @return
     */
    @Override
    public Users selectUserByUserId(int userid) {
        //还是搭建jdbc操作数据库的结构
        Connection conn = null;
        Users user = null;
        try {
            conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("select  * from users where userid = ?");
            ps.setInt(1,userid);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                user = new Users();
                user.setUserid(resultSet.getInt("userid"));
                user.setUsersex(resultSet.getString("usersex"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpwd(resultSet.getString("userpwd"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
                user.setQqnumber(resultSet.getString("qqnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();//开发阶段可以打印
        }finally {
            JDBCUtils.closeCon(conn);
        }
        return user;
    }

    /**
     * 更新用户持久层
     * @param users
     */
    @Override
    public void updateUserById(Users users) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("update users set username = ?,usersex = ?,phonenumber = ?,qqnumber = ? where userid = ?");
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.setString(2,users.getUsersex());
            preparedStatement.setString(3,users.getPhonenumber());
            preparedStatement.setString(4,users.getQqnumber());
            preparedStatement.setInt(5,users.getUserid());
            preparedStatement.execute();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();//开发阶段可以打印
            JDBCUtils.rollback(conn);
        }finally {
            JDBCUtils.closeCon(conn);
        }
    }

    /**
     * 根据用户ID删除用户
     * @param userid
     */
    @Override
    public void deleteUserByUserId(int userid) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("delete users where userid = ?");
            preparedStatement.setInt(1,userid);
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            JDBCUtils.rollback(conn);
        }finally {
            JDBCUtils.closeCon(conn);
        }
    }

    //拼接查询的SQL语句
    private String createSql(Users users){
        //userid和userpwd是不能作为查询条件的
        StringBuffer stringBuffer = new StringBuffer("select * from users where 1=1 ");
        if (users.getUsersex()!=null&&users.getUsersex().length()>0){
            stringBuffer.append("and usersex = "+users.getUsersex());
        }
        if (users.getQqnumber()!=null&&users.getQqnumber().length()>0){
            stringBuffer.append("and qqnumber = "+users.getQqnumber());
        }
        if (users.getUsername()!=null&&users.getUsername().length()>0){
            stringBuffer.append("and username = "+users.getUsername());
        }
        if (users.getPhonenumber()!=null&&users.getPhonenumber().length()>0){
            stringBuffer.append("and phonenumber = "+users.getPhonenumber());
        }

        return stringBuffer.toString();
    }
}
