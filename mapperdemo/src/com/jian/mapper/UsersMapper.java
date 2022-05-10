package com.jian.mapper;

import com.jian.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface UsersMapper {
    List<Users> selectUsersAll();
    Users selectUsersById(int userid);
    //在这定义参数时就可以
    List<Users> selectUsersOrderParam(String username,String usersex);
    //值必须跟配置文件绑定参数的名字相同
    List<Users> selectUsersAnn(@Param("name") String username,@Param("sex") String usersex);
    List<Users> selectUsersPOJOParam(Users users);
    //map第二个泛型，在这里我们两个参数都是String类型，那就给String
    //如果不是相同类型类型就给Object就行了
    List<Users> selectUsersMapParam(Map<String,String> map);
    //需要一个RowBounds类型的参数，如果有其他参数，在参数列表里正常给就行，最后别忘了给RowBounds的参数
    List<Users> selectUsersRowBounds(RowBounds rowBounds);
    List<Users> selectUsersLimit(@Param("offset" ) int offset,@Param("limit") int limit);

    //添加数据，返回添加条数
    int insertUsers(Users users);
    //这里是返回条数不是主键id
    int insertUsersGetKey(Users users);
    void insertUsersGetKey2(Users users);

    List<Users> selectUsersByProperty(Users users);
    List<Users> selectUsersByChoose(Users users);
    List<Users> selectUsersByPropertyWhere(Users users);
    List<Users> selectUsersByLikeName(String name);
    void usersUpdate(Users users);

    List<Users> selectUsersByIdUseCollection(@Param("coll") Collection collection);
    List<Users> selectUsersByIdUseArray(int[] arr);
    int selectUsersCount(@Param("suibian") Map<String,String> map);
                                            //这里也是，value如果既有String又有int那就得Object，
                                            // 现在我们username和usersex都是String类型
    int insertUsersBatch(List<Users> list);



}
