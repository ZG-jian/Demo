package com.jian.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Realm，这里就不关闭资源了，关闭资源在这里不是重点，主要明白一下数据库的连接过程
 * 注意：虽然数据库的表是我们自己定义的，但是整个认证比较的过程还是交给shiro来做的
 */
public class UserRealm extends AuthorizingRealm {
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiro", "root", "123456");
            PreparedStatement preparedStatement = conn.prepareStatement("select pwd from admin where uname = ? ");
            preparedStatement.setObject(1,authenticationToken.getPrincipal());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                //调用有参的构造方法
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(authenticationToken.getPrincipal(),rs.getString("pwd"),"userRealm");
                return info;//查到了返回
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//没查到返回空
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();

        //获得username  然后去数据库查询这个用户对应的角色，再根据角色查询出角色下对应的菜单
        //返回指定角色下的所有的菜单--List
        System.out.println("username="+username);

        //模拟数据库查菜单
        List<String> list = new ArrayList<>();
        list.add("updateUser");
        list.add("addUser");
        list.add("deleteUser");
        //注意别用错了，用授权不是用认证
        SimpleAuthorizationInfo simpleAuthorizationInfo= new SimpleAuthorizationInfo();
        for (String str:list
             ) {
            simpleAuthorizationInfo.addStringPermission(str);
        }
        return simpleAuthorizationInfo;

    }

}
