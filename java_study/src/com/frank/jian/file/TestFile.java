package com.frank.jian.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
    public static void main(String[] args) throws IOException {
//        File f = new File("G:\\0.3testFile");
//        System.out.println("File 是否存在："+f.exists());
//        System.out.println("File 是否是目录："+f.isDirectory());
//        System.out.println("File 是否是文件："+f.isFile());
//        System.out.println("File 最后修改时间："+new Date(f.lastModified()));
//        System.out.println("File 的大小："+f.length());
//        System.out.println("File 的文件名："+f.getName());
//        System.out.println("File 的目录路径："+f.getPath());
//        File f1 = new File("G:\\testFile\\what.txt");
//        f1.createNewFile();//生成txt文件
//        f1.delete();//删除文件
//        File f2 = new File("G:/abm/什么鬼/玛德");
//        boolean flag = f2.mkdir();//目录结构中有一个不存在，则不会创建整个目录树
//        boolean flag2 = f2.mkdirs();//目录结构中有一个不存在也没关系；创建整个目录树
//        System.out.println(flag2);

        File f3 = new File("G:\\project\\Java\\java_study\\myfile\\test01.txt");
        System.out.println("文件是否存在："+f3.exists());
        f3.createNewFile();
        System.out.println("文件是否存在："+f3.exists());
        System.out.println("File 是否是目录："+f3.isDirectory());
        System.out.println("File 是否是文件："+f3.isFile());
        System.out.println("File 的文件名："+f3.getName());
        System.out.println("File 的目录路径："+f3.getPath());
        f3.delete();
        System.out.println("删除后，文件是否存在："+f3.exists());
        System.out.println("-------------------------");
        File f4 = new File("G:\\project\\Java\\java_study\\myfile\\ok\\wtf\\ohh\\what.txt");
        System.out.println(f4.mkdirs());

    }
}
