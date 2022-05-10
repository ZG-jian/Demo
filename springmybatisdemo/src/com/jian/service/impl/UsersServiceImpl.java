package com.jian.service.impl;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.pojo.UsersExample;
import com.jian.service.UsersService;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    /**
     * 添加用户
     * @param users
     */
    @Override
    public void addUsers(Users users) {
        UsersMapper mapper = this.sqlSessionTemplate.getMapper(UsersMapper.class);
        mapper.insertSelective(users);

    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<Users> findUsersAll() {
        //sqlSessionTemplate的getMapper实际上是调用sqlSession的getMapper
        UsersMapper mapper = this.sqlSessionTemplate.getMapper(UsersMapper.class);
        UsersExample usersExample = new UsersExample();
        return mapper.selectByExample(usersExample);//这个方法返回一个List
    }
}
