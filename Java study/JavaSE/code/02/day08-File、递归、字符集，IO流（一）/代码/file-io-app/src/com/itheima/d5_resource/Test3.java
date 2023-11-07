package com.itheima.d5_resource;

import java.io.*;

/**
 * 目标：掌握释放资源的方式：try-with-resource
 */
public class Test3 {
    public static void main(String[] args)  {
        try (
                // 1、创建一个字节输入流管道与源文件接通
                InputStream is = new FileInputStream("file-io-app\\src\\itheima03.txt");
                // 2、创建一个字节输出流管道与目标文件接通。
                OutputStream os = new FileOutputStream("file-io-app\\src\\itheima03copy.txt");

                // 注意：这里只能放置资源对象。（流对象）
                // int age = 21;
                // 什么是资源呢？资源都是会实现AutoCloseable接口。资源都会有一个close方法，并且资源放到这里后
                // 用完之后，会被自动调用其close方法完成资源的释放操作。
                MyConnection conn = new MyConnection();
                ){

            // 3、创建一个字节数组，负责转移字节数据。
            byte[] buffer = new byte[1024]; // 1KB.
            // 4、从字节输入流中读取字节数据，写出去到字节输出流中。读多少写出去多少。
            int len; // 记住每次读取了多少个字节。
            while ((len = is.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }
            System.out.println(conn);
            System.out.println("复制完成！！");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
