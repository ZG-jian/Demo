package com.jian.aop;

import com.jian.mapper.LogsMapper;
import com.jian.pojo.Logs;
import com.jian.pojo.UsersExt;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 用户登录日志记录切面
 */
@Aspect
@Component
public class UsersLoginLogAOP {
    @Autowired
    private LogsMapper logsMapper;
    //使用后置通知来实现用户登录日志的记录

    /**
     * 配置切点   只是去拦截用户登录
     */
    @Pointcut("execution(* com.jian.service.UsersService.userLogin(..))")
    public void myPointcut(){
    }
    /**
     * 在后置通知中记录登录日志
     */
    @AfterReturning("myPointcut()")
    public void userLoginLog(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        UsersExt users = (UsersExt) objects[0];
        Logs logs = new Logs();
        logs.setLogtime(new Date());
        logs.setUsername(users.getUsername());
        logs.setIp(users.getIp());
        this.logsMapper.insertSelective(logs);

    }
}
