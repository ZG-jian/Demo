package test.com.jian.service;

import com.jian.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//更换测试引擎
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//指定spring配置文件
public class UsersServiceImplTest {
    //默认的Junit引擎不启动sprig框架,这个引擎会启动spring框架
    //第一件事换引擎，第二指定配置文件
    @Autowired
    private UsersService usersService;

    @Test
    public void testAddUsers(){
        //在这也可以使用断言。。。
    this.usersService.addUsers();
    }
}
