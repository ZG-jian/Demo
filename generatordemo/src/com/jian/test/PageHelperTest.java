package com.jian.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.pojo.UsersExample;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PageHelperTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        UsersExample usersExample = new UsersExample();
        //没有任何条件不就是查所有
        PageHelper.startPage(3,2);
        List<Users> list = mapper.selectByExample(usersExample);
        PageInfo<Users> pageInfo = new PageInfo<>(list);//这两个的list是相同的，但创建这个对象要给list
        //获取结果集
        List<Users> result = pageInfo.getList();
        result.forEach(System.out::println);
        //获取总条数
        System.out.println("总条数："+pageInfo.getTotal());
        //获取总页数
        System.out.println("总页数："+pageInfo.getPages());
        //获取当前页
        System.out.println("当前页："+pageInfo.getPageNum());
        //获取每页显示的条数
        System.out.println("每页条数："+pageInfo.getSize());
    }
}
