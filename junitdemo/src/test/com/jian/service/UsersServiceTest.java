package test.com.jian.service;

import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;
import org.junit.*;

public class UsersServiceTest {

    @Test
    //测试方法命名
    public void testAddUsers(){
        UsersService usersService = new UsersServiceImpl();
        UsersService usersService1 = usersService;
/*        int flag = usersService.addUsers();
        Assert.assertEquals(1,flag);*/
//        Assert.assertSame(usersService,usersService1);
        Assert.assertTrue("msg",2>1);
    }

   /* @Before
    public void testBefore(){
        System.out.println("Before.....");
    }

    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("BeforeClass.........");
    }
    @After
    public void testAfter(){
        System.out.println("After...");
    }
    @AfterClass
    public static void  testAfterClass(){
        System.out.println("AfterClass......");
    }*/
}
