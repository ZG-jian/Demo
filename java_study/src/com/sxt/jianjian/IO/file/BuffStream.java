package com.sxt.jianjian.IO.file;

import org.junit.Test;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BuffStream {
    @Test
    public void Test(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //这里是分开写的
            //bis = new BufferedInputStream()
            fis = new FileInputStream("file2/meizi.jpeg");
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream("file2/meizi2.jpeg");
            bos = new BufferedOutputStream(fos);

            //缓存，byte数组长度为8192 
            int by;
            while ((by = bis.read()) != -1){
                bos.write(by);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (fis != null){
                    fis.close();
                }

                if (fos != null){
                    fos.close();
                }

                if (bis != null){
                    bis.close();
                }
                if(bos != null){
                    bos.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
