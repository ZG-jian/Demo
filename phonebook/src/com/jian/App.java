package com.jian;

/**
 * 电话本项目入口类
 */
public class App {
    /**
     * 启动电话本项目
     * @param args
     */
    public static void main(String[] args) {
        App app = new App();
        app.start();

    }

    /**
     * 控制主菜单
     */
    public void start(){
        Menu menu = new Menu();
        TelNotRegex regex = new TelNotRegex();
        Operate operate = new Operate();
        while (true){
            menu.mainMenu();
            int item = regex.menuItemValidate(1,6);//主菜单的1-6
            switch (item){
                case 1:operate.addLogic();break;
                case 2:operate.searchLogic();break;
                case 3:operate.modifyLogic();break;
                case 4:operate.deleteLogic();break;
                case 5:operate.orderLogic();break;
                case 6:System.exit(0);
            }
        }
    }
}
