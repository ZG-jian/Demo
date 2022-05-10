package com.jian.mapper;

import com.jian.pojo.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    @Select("select * from users")
    List<Users> selectUsersAll();

    //单个参数，#{}里写什么都可以，也不用@param
    @Select("select * from users where username = #{param1} and usersex = #{param2}")
    List<Users> selectUsersByNameAndSexOrder(String username, String usersex);

    @Select("select * from users where username = #{name} and usersex = #{sex}")
    List<Users> selectUsersByNameAndSexOrder2(@Param("name") String username, @Param("sex") String usersex);

    @Select("select * from users where username = #{username} and usersex = #{usersex}")
    List<Users> selectUsersByNameAndSexPOJO(Users users);


    @Select("select * from users where username = #{keyname} and usersex = #{keysex}")
    List<Users> selectUsersByNameAndSexMap(Map<String,String> map);//现在两个参数都是String,那第二个就String，有其他就Object

    @Insert("insert into users values(default,#{username},#{usersex})")
    int insertUsers(Users users);

    @Update("update users set username = #{username},usersex = #{usersex} where userid = #{userid}")
    int updateUsers(Users users);

    @Delete("delete from users where userid = #{userid}")
    int deleteUsersById(int userid);

        //麻烦死,自己打还不对，有一个xml标签的错
    @Select("<script>select * from users where 1=1 <if test=\" username!=null and username!=''\"> and username=#{username}</if> <if test=\" usersex != null and usersex !=''\"> and usersex =#{usersex}</if></script>")
    List<Users> selectUsersByProperty(Users users);

    /*
    type:指定当前你能生成sql语句的这个类的class是什么
    method：你在这个类当中的哪个方法用于当前这个生成当前这个查询发方法的sql语句
                这种方式也挺繁琐，类，类方法
     */
    @SelectProvider(type =UsersMapperProvider.class,method ="selectUsersByPropertySQL" )
    List<Users> selectUsersByPropertyProvider(Users users);

    @Select("select userid as id,username as name ,usersex as sex from users where userid = #{userid}")
    @Results(id = "usersMapper",value ={
            @Result(id = true,property = "userid",column = "id"),
            @Result(property = "username",column = "name"),
            @Result(property = "usersex",column = "sex")
    } )
    Users selectUsersByIdMapper(int userid);//value是一个result注解类型

    @Select("select userid as id,username as name ,usersex as sex from users where userid = #{userid}")
    @ResultMap(value = {"usersMapper"})//作用就是用来复用results标注解的
    Users selectUsersByIdMapper2(int userid);

    //一对一,在这里就是你返回的Roles要执行哪个查询  如果这个方法名不在UsersMapper接口而是在其他接口当中，那必须加上包名，接口名，方法名
    @Select("select * from users where userid = #{userid}")
    @Results(id = "usersAndRolesMapper",value ={
            @Result(id = true,property = "userid",column = "userid"),
            @Result(property = "username",column = "username"),
            @Result(property = "usersex",column = "usersex"),
            @Result(property = "roles",column = "userid",one = @One(select = "com.jian.mapper.RolesMapper.selectRolesByUserId",fetchType = FetchType.LAZY))
    }
    )
    Users selectUsersAndRolesByUserId(int userid);


    @Select("select * from users where userid = #{userid}")
    @Results(id = "usersAndOrdersMapper",value ={
            @Result(id = true,property = "userid",column = "userid"),
            @Result(property = "username",column = "username"),
            @Result(property = "usersex",column = "usersex"),
//            把userid作为查询条件
            @Result(property = "orders" ,column = "userid",many = @Many(select = "com.jian.mapper.OrdersMapper.selectOrdersByUserId",fetchType = FetchType.LAZY))
    }
    )
    Users selectUsersAndOrdersByUserId(int userid);

    //类在哪定义都可以，因为就是给这个接口用的，拿整内部类没关系
    class UsersMapperProvider{
        /**
         * 生成动态sql
         */
        public String selectUsersByPropertySQL(Users users){
            StringBuffer sb = new StringBuffer("select * from users where 1=1");
            if(users.getUsername()!=null && users.getUsername()!=""){
                sb.append(" and username = #{username}");
            }
            if (users.getUsersex()!=null&&users.getUsersex()!=""){
                sb.append(" and usersex = #{usersex}");
            }
            return sb.toString();
        }
    }

}
