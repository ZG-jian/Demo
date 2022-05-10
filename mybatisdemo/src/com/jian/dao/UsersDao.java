package com.jian.dao;

import com.jian.pojo.Users;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UsersDao {
    List<Users> selectUsersAll() throws IOException;
    Users selectUsersById(int userid)throws IOException;
    void insertUsers(Users users);
    Users selectUsersById2(int userid);
    void updateUsersById(Users users);
    void deleteUsersById(int userid);
    Map<Integer,Users> selectUserByNameAndSex(String username,String usersex);


}
