package com.itheima.d5_resource;

import java.io.*;

/**
 * 目标：掌握释放资源的方式。
 */
public class Test2 {
    public static void main(String[] args)  {
        InputStream is = null;
        OutputStream os = null;
        try {
            System.out.println(10 / 0);
            // 1、创建一个字节输入流管道与源文件接通
            is = new FileInputStream("file-io-app\\src\\itheima03.txt");
            // 2、创建一个字节输出流管道与目标文件接通。
            os = new FileOutputStream("file-io-app\\src\\itheima03copy.txt");

            System.out.println(10 / 0);

            // 3、创建一个字节数组，负责转移字节数据。
            byte[] buffer = new byte[1024]; // 1KB.
            // 4、从字节输入流中读取字节数据，写出去到字节输出流中。读多少写出去多少。
            int len; // 记住每次读取了多少个字节。
            while ((len = is.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }
            System.out.println("复制完成！！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放资源的操作
            try {
                if(os != null) os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
