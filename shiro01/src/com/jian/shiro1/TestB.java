package com.jian.shiro1;

import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.IncorrectCredentialsException;



import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TestB {
    public static void main(String[] args) {
        //[1] 解析shiro.ini文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc.ini");
        //[2] 通过SecurityManager工厂获得SecurityManager实例
        SecurityManager securityManager = factory.getInstance();
        //[3] 把securityManages对象设置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //[4]通过SecurityManager获得主体对象subject
        Subject subject = SecurityUtils.getSubject();
        //[5]书写自己输入的账号和密码----相当于用户自己输入的账号和密码
        //我们拿着自己书写的用户名和密码取和shiro.ini文件中的账号密码比较
        UsernamePasswordToken token = new UsernamePasswordToken("jian1","root");

        try {
            //[6]进行身份的验证
            subject.login(token);
            //[7]通过方法判断是否登录成功
            if (subject.isAuthenticated()){
                System.out.println("登录成功！！");
            }
        } catch (IncorrectCredentialsException e) {
            System.out.println("凭证不正确（密码错了）");
        }catch (org.apache.shiro.authc.UnknownAccountException e){
            System.out.println("用户名不正确。。");
        }

    }
}
