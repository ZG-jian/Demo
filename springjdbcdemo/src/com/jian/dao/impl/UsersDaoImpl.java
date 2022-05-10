package com.jian.dao.impl;

import com.jian.dao.UsersDao;
import com.jian.pojo.Users;
import org.springframework.jdbc.core.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 添加用户
     * @param users
     * @return
     */
    @Override
    public int insertUsers(Users users) {
        String sql = "insert into users values(default,?,?)";
        Object[] params = new Object[]{users.getUsername(),users.getUsersex()};
        return this.jdbcTemplate.update(sql,params);//帮我们完成sql语句的执行和参数的绑定
    }

    /**
     * 批量添加用户
     * @param users
     * @return
     */
    @Override
    public int[] batchInsertUsers(List<Users> users) {
        String sql = "insert into users values(default,?,?)";
        BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Users temp = users.get(i);
                preparedStatement.setString(1,temp.getUsername());
                preparedStatement.setString(2,temp.getUsersex());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        };
        return this.jdbcTemplate.batchUpdate(sql,setter);
    }

    /**
     * 根据用户ID查询用户
     * @param userid
     * @return
     */
    @Override
    public Users selectUsersById(int userid) {
        String sql = "select * from users where userid = ?";
        Object[] params = new Object[]{userid};
        Users users = new Users();
        this.jdbcTemplate.query(sql, params, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                users.setUserid(resultSet.getInt("userid"));
                users.setUsername(resultSet.getString("username"));
                users.setUsersex(resultSet.getString("usersex"));
            }
        });
        return users;
    }

    /**
     * 查询用户返回多条数据
     * @param username
     * @return
     */
    @Override
    public List<Users> selectUsersByName(String username) {
        String sql = "select * from users where username = ?";
        Object[] params = new Object[]{username};
        return this.jdbcTemplate.query(sql, params, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                Users users = new Users();
                users.setUserid(resultSet.getInt("userid"));
                users.setUsername(resultSet.getString("username"));
                users.setUsersex(resultSet.getString("usersex"));
                return users;
            }
        });
    }

    @Override
    public List<Users> selectUsersByName2(String username) {
        String sql = "select * from users where username = ?";
        Object[] params = new Object[]{username};
        //你要把结果集映射到哪个实体当中，就把哪个实体的class给他
        return this.jdbcTemplate.query(sql,params,new BeanPropertyRowMapper<>(Users.class));
    }
}
