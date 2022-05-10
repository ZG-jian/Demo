package com.jian.shiro2;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        return null;
    }

}
