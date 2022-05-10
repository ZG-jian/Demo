package com.jian.dao.impl;

import com.jian.Utils.MybatisUtils;
import com.jian.dao.UsersDao;
import com.jian.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersDaoImpl implements UsersDao {
    /**
     * 查询所有用户
     * @return
     * @throws IOException
     */
    @Override
    public List<Users> selectUsersAll() throws IOException {
        //创建SqlSessionFactory对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession对象下的API完成对数据库的操作
        //从映射配置文件拿sql语句
        List<Users> list = sqlSession.selectList("com.jian.mapper.UserMapper.selectUsersAll");
        //关闭SqlSession对象
        sqlSession.close();
        return list;
    }

    /**
     * 根据ID查询用户
     * @param userid
     * @return
     * @throws IOException
     */
    @Override
    public Users selectUsersById(int userid) throws IOException {
        //创建SqlSessionFactory对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Users users = sqlSession.selectOne("com.jian.mapper.UserMapper.selectUsersById",userid);
        return users;
    }

    /**
     * 添加用户
     * @param users
     */
    @Override
    public void insertUsers(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.insert("com.jian.mapper.UserMapper.insertUsers",users);
    }

    /**
     * 预更新的查询
     * @param userid
     * @return
     */
    @Override
    public Users selectUsersById2(int userid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Users users = sqlSession.selectOne("com.jian.mapper.UserMapper.selectUsersById2",userid);
        return users;
    }

    /**
     * 更新用户
     * @param users
     */
    @Override
    public void updateUsersById(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int update = sqlSession.update("com.jian.mapper.UserMapper.updateUsersById", users);
    }

    @Override
    public void deleteUsersById(int userid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int delete = sqlSession.delete("com.jian.mapper.UserMapper.deleteUsersById", userid);
    }

    @Override
    public Map<Integer, Users> selectUserByNameAndSex(String username, String usersex) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Map<String,String> param = new HashMap<>();
        //这里就要给映射文件的参数名
        param.put("name",username);
        param.put("sex",usersex);
        //执行查询并返回一个有userid对应的User
        Map<Integer, Users> users = sqlSession.selectMap("com.jian.mapper.UserMapper.selectUsersByNameAndSex", param, "userid");

        return users;
    }
}
