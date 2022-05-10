package com.frank.jian.intAndOut;

import org.junit.Test;

import java.io.*;

public class TestIo {
    //字节流，可读取任何文件。视频音频图片
    @Test
    public void inputFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("myfile/1.txt");
        int by;

//        StringBuilder sb = new StringBuilder();
        while ((by = fileInputStream.read()) != -1) {
            System.out.print((char) by);
//            sb.append((char)by);//也可以用StringBuilder结果一样
        }
        fileInputStream.close();
//        System.out.println(sb.toString());
    }

    @Test
    public void outputFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("myfile/2.txt");
        byte[] bytes = "Fuck_Student".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            fileOutputStream.write(bytes[i]);
        }
        fileOutputStream.close();
    }

    @Test
    public void copyFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("myfile/1.png");
        FileOutputStream fileOutputStream = new FileOutputStream("myfile/copy.png");
        //缓冲区
        byte[] buff = new byte[1024];
        int by;
        //这里还要读缓冲区
        while ((by = fileInputStream.read(buff)) != -1) {
            fileOutputStream.write(buff);
//            fileOutputStream.write(buff, 0, by);//这样也行
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void buffFileBase() throws IOException {
        //vip 装饰设计模式
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("myfile/1.txt"));

//        int by;
//        while ((by = bufferedInputStream.read())!=-1){
//            System.out.print((char) by);
//        }

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("myfile/yousee.txt"));

        int by;
        while ((by = bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(by);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    //   字符流 FileReader 和FileWriter 专门处理txt文件
    @Test
    public void fileReader() throws IOException {
        FileReader fileReader = new FileReader("myfile/1.txt");
        int ch;
        while ((ch = fileReader.read()) !=-1){
            System.out.print((char)ch);
        }
        fileReader.close();
    }

    @Test
    public void fileWriter() throws IOException{
        FileWriter fileWriter = new FileWriter("myfile/fileWriter.txt");
        fileWriter.write("Go fuck yourself\n");
            fileWriter.close();
    }

    //升级vip服务，要new一个基本的
    @Test
    public void bufferFileReader() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("myfile/1.txt"));
        String str;
        while ((str = bufferedReader.readLine())!=null){
            System.out.println(str);
        }
        bufferedReader.close();
    }

    @Test
    public void bufferFileWriter() throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("myfile/bufferWriter.txt"));
        bufferedWriter.write("123456789");
        bufferedWriter.newLine();
        bufferedWriter.write("66666666");
        bufferedWriter.close();
    }


}
