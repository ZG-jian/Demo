package Test;

import pojo.Info;
import service.InfoService;
import service.impl.InfoServiceImpl;

public class TestDemo2 {
    public static void main(String[] args) {
/**
 *一开始是没有导入驱动的jar包
 * 然后导入了也不行，关键在配置文件要放在src下
 */

//添加测试
        Info info = new Info();
        info.setName("jianjian22");
        info.setAge(18);
        InfoService is = new InfoServiceImpl();
//        is.addInfo(info);

        //根据名字查找测试
//        for (Info a:is.selectInfo("jianjian")
//             ) {
//            System.out.println(a.getId()+"    "+a.getName()+"    "+a.getAge());
//
//        }

        //更新的测试
        Info info1 = new Info();
        info1.setName("更新");
        info1.setAge(1);
        info1.setId(1);
        System.out.println(is.modifyInfo(info1));


    }
}
