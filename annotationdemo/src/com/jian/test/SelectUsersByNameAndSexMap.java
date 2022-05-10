package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectUsersByNameAndSexMap {
    public static void main(String[] args) {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Map<String,String> map = new HashMap<>();
        map.put("keyname","jian");
        map.put("keysex","male");
    List<Users> list = mapper.selectUsersByNameAndSexMap(map);
    list.forEach(System.out::println);

}
}
