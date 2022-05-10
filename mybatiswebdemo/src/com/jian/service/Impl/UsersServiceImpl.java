package com.jian.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.pojo.UsersExample;
import com.jian.service.UsersService;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 操作用户业务层
 */
public class UsersServiceImpl implements UsersService {
    /**
     * 添加用户
     * @param users
     */
    @Override
    public void addUsers(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        mapper.insertSelective(users);
    }

    /**
     * 查询用户
     * @param page
     * @param users
     * @return
     */
    @Override
    public PageInfo<Users> findUSers(int page, Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        UsersExample usersExample = this.createUsersExample(users);
        PageHelper.startPage(page,2);
        List<Users> list = mapper.selectByExample(usersExample);
        PageInfo<Users> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }
    /**
     * 生成查询条件
     *
     */
    private UsersExample createUsersExample(Users users){
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        //判断，任何添加条件
        if(users.getUsername()!=null&&users.getUsername().length()>0){
            criteria.andUsersexEqualTo(users.getUsername());
        }
        if (users.getUsersex()!=null&&users.getUsersex().length()>0){
            criteria.andUsersexEqualTo(users.getUsersex());
        }
        return usersExample;
    }
}
