package com.jian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 核心业务类
 */
public class Operate {
    private List<Person> list;

    public Operate() {
        list = new ArrayList<>();
    }

    /**
     * 用户添加记录业务逻辑控制
     */
    public void addLogic(){
        Menu menu = new Menu();//创建主菜单对象
        TelNotRegex regex = new TelNotRegex();//创建数据效验类对象
        while (true){
            menu.addMenu();//调用添加菜单方法
            int item = regex.menuItemValidate(1,3);//添加菜单菜单项的效验
            switch (item){
                //因为在Operate类里，所以调用this
                case 1:this.addOperation();break;//调用添加新纪录方法
                case 2:this.showAll();break;//调用查询全记录方法
                case 3:return;//返回上一级，也就是结束当前方法
            }
        }
    }

    /**
     * 用户查询记录业务逻辑控制
     */
    public void searchLogic(){
        Menu menu = new Menu();
        TelNotRegex telNotRegex = new TelNotRegex();
        while (true){
            menu.searchMenu();//调用查找菜单方法
            int item = telNotRegex.menuItemValidate(1,7);
            switch (item){
                case 1:this.searchByName();break;
                case 2:this.searchByAge();break;
                case 3:this.searchBySex();break;
                case 4:this.searchByTelNum();break;
                case 5:this.searchByAdd();break;
                case 6:showAll();break;
                case 7:return;
            }

        }

    }
    /**
     * 修改记录业务逻辑控制
     */
    public void modifyLogic(){
        Menu menu = new Menu();
        TelNotRegex telNotRegex = new TelNotRegex();
        while (true){
            menu.modifyMenu();
            int item = telNotRegex.menuItemValidate(1,3);
            switch (item){
                case 1:this.showAll();break;
                case 2:this.modifyOperation();break;
                case 3:return;
            }
        }

    }
    /**
     * 删除记录业务逻辑控制
     */
    public void deleteLogic(){
        Menu menu = new Menu();
        TelNotRegex telNotRegex = new TelNotRegex();
        while (true){
            menu.deleteMenu();
            int item = telNotRegex.menuItemValidate(1,4);
            switch (item){
                case 1:this.showAll();break;
                case 2:this.deleteOperation();break;
                case 3:this.deleteAllOperation();break;
                case 4:return;
            }
        }

    }
    /**
     * 排序记录业务逻辑控制
     */
    public void orderLogic(){
        Menu menu = new Menu();
        TelNotRegex telNotRegex = new TelNotRegex();
        while (true){
            menu.orderMenu();
            int item = telNotRegex.menuItemValidate(1,5);
            switch (item){
                case 1:this.orderName();break;
                case 2:this.orderAge();break;
                case 3:this.orderSex();break;
                case 4:this.showAll();break;
                case 5:return;
            }
        }
    }

    /**
     * 添加新记录信息
     */
    public void addOperation(){
        TelNotRegex telNotRegex = new TelNotRegex();
        String name = telNotRegex.nameValidate();
        String age = telNotRegex.ageValidate();
        String sex = telNotRegex.sexValidate();
        String telNum = telNotRegex.telNumValidate();
        String address = telNotRegex.addressValidate();
        Person person = new Person(name,age,sex,telNum,address);
        this.list.add(person);
        person.setId(this.list.size());
        }

    /**
     * 查询全部记录
     */
    public void showAll(){
        if (this.list.size()==0){
            System.out.println("没有任何记录");
            return;
        }
        for (int i = 0; i <this.list.size() ; i++) {
            System.out.println(this.list.get(i));

        }
    }

    /**
     * 按姓名查询记录
     */
    public void searchByName(){
        TelNotRegex telNotRegex = new TelNotRegex();
        String name = telNotRegex.nameValidate();//获得要找的合法姓名
        boolean flag = true;
        for (int i = 0; i <this.list.size() ; i++) {
            if (name.equals(this.list.get(i).getName())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if (flag){
            System.out.println("没有此人记录");
        }
}

    /**
     * 按年龄查询记录
     */
    public void searchByAge(){
        TelNotRegex telNotRegex = new TelNotRegex();
        String age = telNotRegex.ageValidate();
        boolean flag = true;
        for (int i = 0; i <this.list.size() ; i++) {
            if (age.equals(this.list.get(i).getAge())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if (flag){
            System.out.println("没有找到这个这个年龄的记录");
        }
    }

    /**
     * 按性别查询记录
     */
    public void searchBySex(){
        TelNotRegex telNotRegex = new TelNotRegex();
        String sex = telNotRegex.sexValidate();
        boolean flag = true;
        for (int i = 0; i < this.list.size(); i++) {
            if (sex.equals(this.list.get(i).getSex())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if (flag){
            System.out.println("没有找到对应记录");
        }
    }

    /**
     * 按电话号码查询记录
     */
    public void searchByTelNum(){
        TelNotRegex telNotRegex = new TelNotRegex();
        String telNum = telNotRegex.telNumValidate();
        boolean flag = true;
        for (int i = 0; i <this.list.size() ; i++) {
            if (telNum.equals(this.list.get(i).getTelNun())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if (flag){
            System.out.println("没有相应的记录");
        }
    }

    /**
     * 按地址查询记录
     */
    public void searchByAdd(){
        TelNotRegex telNotRegex = new TelNotRegex();
        String address = telNotRegex.addressValidate();
        boolean flag = true;
        for (int i = 0; i <this.list.size() ; i++) {
            if (address.equals(this.list.get(i).getAddress())){
                System.out.println(this.list.get(i));
                flag = false;
            }
        }
        if (flag){
            System.out.println("没有找到这个地址的记录");
        }
    }


    /**
     * 修改指定记录
     */
    public void modifyOperation(){
        TelNotRegex telNotRegex = new TelNotRegex();
        Menu menu = new Menu();
        //对被修改的序号进行验证，可使用对菜单验证项的方法来完成
        System.out.println("请输入记录的序号");
        int itemNum = telNotRegex.menuItemValidate(1,this.list.size());
        menu.subModifyMenu();//调出修改子菜单
        int menuItem = telNotRegex.menuItemValidate(1,6);
        //下面都是先获得一个合法的修改值，再去根据序号修改要修改的属性
        switch (menuItem){
            case 1:String name = telNotRegex.nameValidate();
                (this.list.get(itemNum-1)).setName(name);break;
            case 2:String age = telNotRegex.ageValidate();
                (this.list.get(itemNum-1)).setAge(age);break;
            case 3:String sex = telNotRegex.sexValidate();
            (this.list.get(itemNum-1)).setSex(sex);break;
            case 4:String telNum = telNotRegex.telNumValidate();
                (this.list.get(itemNum-1)).setTelNun(telNum);break;
            case 5:String address = telNotRegex.addressValidate();
                (this.list.get(itemNum-1)).setAddress(address);break;
            case 6:return;
        }


    }

    /**
     *  删除指定记录
     */
    public void deleteOperation(){
        TelNotRegex telNotRegex = new TelNotRegex();
        System.out.println("请输入要删除的序号");
        int itemNum = telNotRegex.menuItemValidate(1,this.list.size());//获取合法输入序号
        //删除,一开始忘记-1，测试有下标越界异常
        this.list.remove(itemNum-1);
        //重新设置序号
        for (int i = 0; i <this.list.size() ; i++) {
            (this.list.get(i)).setId(i+1);
        }
        System.out.println("删除成功，请继续操作！");

    }

    /**
     *  删除全部记录
     */
    public void deleteAllOperation(){
        this.list.clear();
        System.out.println("电话本中的所有记录已清空，请继续");
    }

    /**
     * 按用户姓名排序记录
     */
    public void orderName(){
        Collections.sort(this.list,new OrderByName());
        for (int i = 0; i <this.list.size() ; i++) {
            (this.list.get(i)).setId(i+1);
        }
    }

    /**
     * 按用户年龄排序记录
     */
    public void orderAge(){
        Collections.sort(this.list,new OrderByAge());
        for (int i = 0; i <this.list.size() ; i++) {
            (this.list.get(i)).setId(i+1);
        }
    }

    /**
     * 按用户性别排序记录
     */
    public void orderSex(){
        Collections.sort(this.list,new OrderBySex());
        for (int i = 0; i <this.list.size() ; i++) {
            (this.list.get(i)).setId(i+1);
        }

    }
    //三个比较器类
    /**
     * 按用户姓名排序记录
     */
    class OrderByName implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    /**
     *  按用户年龄排序记录
     */
    class OrderByAge implements  Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    }
    /**
     * 按用户性别排序记录
     */
    class OrderBySex implements  Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getSex().compareTo(o2.getSex());
        }
    }
}
