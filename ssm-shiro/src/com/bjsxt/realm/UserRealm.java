package com.bjsxt.realm;

import com.bjsxt.pojo.Admin;
import com.bjsxt.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm，这里就不关闭资源了，关闭资源在这里不是重点，主要明白一下数据库的连接过程
 * 注意：虽然数据库的表是我们自己定义的，但是整个认证比较的过程还是交给shiro来做的
 */
public class UserRealm extends AuthorizingRealm {//这个bean对象已经在配置文件里注册了
    @Autowired
    AdminService adminService;
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //直接调用service层就行了
        Admin admin = adminService.findPwd(authenticationToken.getPrincipal().toString());
        if (admin!=null){//说明账号存在且找到
            //我们现在还是不去做数据的比较，还是给Shiro来做
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin,admin.getPassword(), ByteSource.Util.bytes(admin.getSalt()),"userRealm");
            return info;
        }
        return null;
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Admin admin = (Admin) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //就不保存菜单了，保存role,多个就遍历list一个个admin.getRole保存
        //把角色的名称保存到SimpleAuthorizationInfo
        info.addRole(admin.getRole().getRname());
        return info;
    }

}
