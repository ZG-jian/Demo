package Test;

import pojo.Info;
import service.InfoService;
import service.impl.InfoServiceImpl;

public class TestDemo2 {
    public static void main(String[] args) {

        Info info = new Info();
        info.setName("jianjian");
        info.setAge(18);
        InfoService is = new InfoServiceImpl();
        is.addInfo(info);
    }
}
