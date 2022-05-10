package com.sxt.jianjian.IO.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;

public class TestIO {

    @Test
    //字符输入输出流
    public void ReadAndWrite() {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("file2/01.txt");
            fw = new FileWriter("file2/FileWrite.txt");
////跟之前一样循环读入
            int by;
            while ((by = fr.read())!=-1){
                System.out.print((char)by);
            }

            fw.write("ohhhhhhhhhhhhhhhh");
            fw.flush();
        } catch (Exception e) {

        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //字符缓存文件复制
    public void BuffReadAndWrite() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("file2/01.txt"));
            bw = new BufferedWriter(new FileWriter("file2/buffCopy.txt", true));
            //在FileWriter里面添加了布尔值表示这个文件不会重新生成，也可以说是覆盖。
            //而且写入的内容是从文件的结尾开始写入。
            //说白了就是续写，原来的内容还在
            String temp = "";
//
//           while ((temp = br.readLine())!= null){
//               System.out.println(temp);
//           }

//老问题,同时while打印和下面输出，下面的while输出会没了
            String by;
            int i = 1;
            while ((by = br.readLine()) != null) {
//这里加上每行打印数字
                bw.write(i + "." + by);
                bw.newLine();
                i++;
            }
            bw.write("ohhhhhh");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    //转换流,不在main里跑不起来？？
    //没使用scanner对象和system.out也实现了
    public void ConversionStream() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while (true) {
                bw.write("请输入：");
                bw.flush();
                String str = br.readLine();
                if ("exit".equals(str)) {
                    break;

                }
                bw.write("您输入的是：" + str);
                bw.newLine();
                bw.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
//字符输出流
    public void PrintWriterTest() {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            //这里使用字符缓冲流读入
            br = new BufferedReader(new InputStreamReader(new FileInputStream("file2/01.txt")));
            pw = new PrintWriter("file2/pw_out.txt");

            String temp = "";
            int i = 1;
            while ((temp = br.readLine()) != null) {
                pw.println(i + "." + temp);
                i++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //字节数组流
    public void ByteArrayInputStreamDemo() {
        //String使用平台的默认字符集将其编码为字节序列，并将结果存储到新的字节数组中。
        byte[] arr = "What the fuck?".getBytes();
        ByteArrayInputStream bis = null;
        StringBuilder sb = new StringBuilder();
        try {
            //该构造方法的参数就是字节数组，这个字节数组就是数据源
            bis = new ByteArrayInputStream(arr);
            int by;
            while ((by = bis.read()) != -1) {
                sb.append((char) by);
            }
            System.out.println(sb.toString());
        } finally {
            try {
                bis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void ByteArrayOutputStreamDemo() {
        //通过字符数组输出流把这些元素写入到了数组当中，感觉是麻烦化了
        ByteArrayOutputStream bos = null;
        StringBuilder sb = new StringBuilder();

        try {
            bos = new ByteArrayOutputStream();
            bos.write('l');
            bos.write('o');
            bos.write('v');
            bos.write('e');
            byte[] arr = bos.toByteArray();
            for (int i = 0; i < arr.length; i++) {
                sb.append((char) arr[i]);
            }
            System.out.println(sb.toString());

        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //数据流
    @Test
    //输出
    public void DataOutputStreamDemo() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("file2/dataTest.txt")));
            dos.writeChar('f');
            dos.writeDouble(Math.random());
            dos.writeInt(888);
            dos.writeUTF("什么鬼，wdnmd");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //输入
    @Test
    public void DataInputStreamDemo() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream("file2/dataTest.txt")));
            //直接读取数据，注意:读取的顺序要跟写入的顺序一样，否则不能正常读取
            System.out.println("char:"+dis.readChar());
            System.out.println("double:"+dis.readDouble());
            System.out.println("int："+dis.readInt());
            System.out.println("String："+dis.readUTF());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(dis!=null){
                    dis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //对象流_写出基本类型,读取跟数据流一样
    @Test
    public void ObjectOutputStreamDemo(){
        //跟TMD数据流里面一样
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("file2/ObjectOut.txt")));
            oos.writeInt(666);
            oos.writeBoolean(true);
            oos.writeDouble(Math.random());
            oos.writeUTF("靓仔你好呀jian");
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    //对象流-处理对象,第一次打的时候Users类没有实现标识接口，报异常
    @Test
    public void ObjectOutputStreamTest(){
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("file2/ObjectOutUser.txt"));
            Users users = new Users(1,"简简","18");
            oos.writeObject(users);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    @Test
    public void ObjectInputStreamTest(){
        ObjectInputStream ois = null;
        try {
          ois = new ObjectInputStream(new FileInputStream("file2/ObjectOutUser.txt"));
          Users users = (Users) ois.readObject();
            System.out.println(users.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(ois!=null){
                    ois.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Test
    //随机访问流
    public void RandomAccessStreamDemo(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("file2/RandomTest.txt","rw");
            int[] arr = new int[]{10,20,30,40,50,60,70,80,90,100};
            for (int i = 0; i <arr.length ; i++) {
                raf.writeInt(arr[i]);
            }
            raf.seek(4);
            System.out.println(raf.readInt());

            //隔一个读一个数据
            for (int i = 0; i < 10; i+=2) {
                raf.seek(i*4);
                System.out.print(raf.readInt()+"\t");
            }
            //替换,在第8个字节的位置插入一个新的数据45替换原来的30
            raf.seek(8);
            raf.writeInt(45);
            System.out.println();
            for (int i = 0; i < 10; i+=2) {
                raf.seek(i*4);
                System.out.print(raf.readInt()+"\t");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(raf!=null){
                    raf.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Test
    //File_Utils
    public void File_UtilsOutputDemo() throws IOException {
        //一行代码完事
       String str =  FileUtils.readFileToString(new File("file2/01.txt"),"utf-8");
        System.out.println(str);
    }

    @Test
    //目录拷贝
    public void File_UtilsCopyDemo() throws IOException {
        //    可/或者\\
        //new接口，然后使用匿名内部类实现
        FileUtils.copyDirectory(new File("G:/File_Utils"), new File("G:/UtilsCopy"), new FileFilter() {
            //在文件拷贝时的过滤条件
            //返回true需要做拷贝，返回false不需要做拷贝
            @Override
            public boolean accept(File pathname) {
                //使用FileFilter过滤目录和jpeg结尾文件
                //如果它是目录或者它的文件结尾是jepg，则拷贝
                if (pathname.isDirectory()||pathname.getName().endsWith("jpeg")||pathname.getName().endsWith("html")){
                    return true;
                }
                return false;
            }
        });
    }

    @Test
    //IO_Utils
    public void IO_UtilsDemo() throws IOException {
        //用文件的字节输入流，通过toString方法将字节转换为字符串
        String str = new IOUtils().toString(new FileInputStream("file2/01.txt"),"utf-8");
        System.out.println(str);
    }
    public static void main(String[] args) {
        TestIO testIO = new TestIO();
        testIO.ConversionStream();
    }
}







