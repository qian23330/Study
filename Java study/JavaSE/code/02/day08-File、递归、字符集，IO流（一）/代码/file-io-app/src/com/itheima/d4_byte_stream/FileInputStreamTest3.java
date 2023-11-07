package com.itheima.d4_byte_stream;

import java.io.*;

/**
 * 目标：使用文件字节输入流一次读取完文件的全部字节。
 */
public class FileInputStreamTest3 {
    public static void main(String[] args) throws Exception {
        // 1、一次性读取完文件的全部字节到一个字节数组中去。
        // 创建一个字节输入流管道与源文件接通
        InputStream is = new FileInputStream("file-io-app\\src\\itheima03.txt");

        // 2、准备一个字节数组，大小与文件的大小正好一样大。
//        File f = new File("file-io-app\\src\\itheima03.txt");
//        long size = f.length();
//        byte[] buffer = new byte[(int) size];
//
//        int len = is.read(buffer);
//        System.out.println(new String(buffer));
//
//        System.out.println(size);
//        System.out.println(len);

        byte[] buffer = is.readAllBytes();
        System.out.println(new String(buffer));

        is.close(); // 关闭流
    }
}
