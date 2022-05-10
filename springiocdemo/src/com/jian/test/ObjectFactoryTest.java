package com.jian.test;

        import com.jian.service.UsersService;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectFactoryTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService2 = (UsersService) applicationContext.getBean("usersService2");
        usersService2.addUsers();
    }
}
