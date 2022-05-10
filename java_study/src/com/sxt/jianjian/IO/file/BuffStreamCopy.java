package com.sxt.jianjian.IO.file;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BuffStreamCopy {
    @Test
    public void copy(){
        BufferedInputStream bis =null;
        BufferedOutputStream bos =null;
        try {
             bis = new BufferedInputStream(new FileInputStream("file2/meizi.jpeg"));
             bos = new BufferedOutputStream(new FileOutputStream("file2/meiziCopy.jpeg"));
             int by;
             while ((by = bis.read())!=-1){
                bos.write(by);
             }
             bos.flush();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (bis!=null){
                    bis.close();
                }
                if (bos!=null){
                    bos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
