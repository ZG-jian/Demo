package com.jian.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        //[1] 解析shiro.ini文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //[2] 通过SecurityManager工厂获得SecurityManager实例
        SecurityManager securityManager = factory.getInstance();
        //[3] 把securityManages对象设置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //[4]通过SecurityManager获得主体对象subject
        Subject subject = SecurityUtils.getSubject();
        //[5]书写自己输入的账号和密码----相当于用户自己输入的账号和密码
        //我们拿着自己书写的用户名和密码取和shiro.ini文件中的账号密码比较
        UsernamePasswordToken token = new UsernamePasswordToken("zs","123");

        try {
            //[6]进行身份的验证
            subject.login(token);
            //[7]通过方法判断是否登录成功
         /*   if (subject.isAuthenticated()){
                System.out.println("登录成功！！");
            }*/
        } catch (IncorrectCredentialsException e) {
            System.out.println("登录失败");
        }


        //授权的查询
        //基于角色的授权

        boolean role1 = subject.hasRole("role1");
//        System.out.println(role1);

        //判断是否具有多个角色
        boolean[] booleans = subject.hasRoles(Arrays.asList("role1", "role3"));
    /*    for (Boolean b: booleans
             ) {
            System.out.println(b);
        }*/

    //可以使用checkRole来判断指定用户是否哦具有对应角色
        //如果没有指定角色就会抛出异常UnauthorizedException
    /*subject.checkRole("role3");

    subject.checkRoles("role1","role2");*///也是没有就抛错
        //使用的话，看场景，只看有没有就上面的hasRole，要是还打算做什么就是用checkRole

        //基于资源的授权
        //判断是否具有单个资源
        boolean flag = subject.isPermitted("add");
        System.out.println(flag);

        //判断是否具有多个资源
        boolean permittedAll = subject.isPermittedAll("add", "update", "oooo");//但是这里就不是返回数组了
        //通过checkPermission 进行判断指定用户下是否有指定的资源，没有抛出异常UnauthorizedException
        subject.checkPermission("uuu");//检测一个
        subject.checkPermissions();//多个

    }
}
