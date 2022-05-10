package com.jian.dao.impl;

import com.jian.dao.UsersDao;
import com.jian.pojo.Users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class UsersDaoImplSupport extends JdbcDaoSupport implements UsersDao {
    @Override
    public int insertUsers(Users users) {
        return 0;
    }

    @Override
    public int[] batchInsertUsers(List<Users> users) {
        return new int[0];
    }

    @Override
    public Users selectUsersById(int userid) {
        return null;
    }

    @Override
    public List<Users> selectUsersByName(String username) {
        return null;
    }

    @Override
    public List<Users> selectUsersByName2(String username) {
        String sql = "select * from users where username = ?";
        Object[] params = new Object[]{username};
        return this.getJdbcTemplate().query(sql,params,new BeanPropertyRowMapper<>(Users.class));
    }
}
