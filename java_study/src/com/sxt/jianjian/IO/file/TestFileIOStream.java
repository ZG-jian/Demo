package com.sxt.jianjian.IO.file;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileIOStream {
    @Test
    public void fileStream(){
        //创建字节输入流对象
        FileInputStream fis = null;
        //创捷字节输出流对象
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("file2/01.txt");
            int by;

            fos = new FileOutputStream("file2/01copy.txt");

//            while ((by = fis.read()) != -1){
//                System.out.print((char) by);
//            }
            //这样就可以，但是上面如果也有循环只打印下面只输出的话
            //好像就不会输出了
            //但是改成下面的循环里读入并打印并输出就没有任何毛病
            while ((by = fis.read()) != -1){
                System.out.print((char) by);
                fos.write(by);
            }

        //将数据从内存写到磁盘中
            fos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
//这种写法，保证了即使遇到异常情况，也会关闭流对象。
                if (fis != null) {
                    fis.close();
                }
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
