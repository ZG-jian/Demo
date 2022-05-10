package com.jian.dao.impl;

import com.jian.commons.JDBCUtils;
import com.jian.dao.UsersLoginDao;
import com.jian.pojo.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDaoImpl implements UsersLoginDao {
    /**
     * 用户登录的数据库查询
     * @param username
     * @param userpwd
     * @return
     */
    @Override
    public Users selectUsersByUserNameAndUserPwd(String username, String userpwd) {
        Users user = null;//先给空，未来在业务层好判断用户有没有查询到，直接判断它为不为空就可以了
        //使用jdbc进行查询
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from users where username = ? and userpwd = ?");
            ps.setString(1,username);
            ps.setString(2,userpwd);
            ResultSet resultSet = ps.executeQuery();//执行查询并返回结果集
            while (resultSet.next()){
            user = new Users();
            user.setUsersex(resultSet.getString("usersex"));
            user.setUserpwd(resultSet.getString("userpwd"));
            user.setUsername(resultSet.getString("username"));
            user.setUserid(resultSet.getInt("userid"));
            user.setPhonenumber(resultSet.getString("phoneNumber"));
            user.setQqnumber(resultSet.getString("QqNumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        }
        return user;
    }
}
