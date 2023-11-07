package com.itheima.d4_byte_stream;

import java.io.*;

/**
 * 目标：掌握文件字节输入流，每次读取一个字节。
 */
public class FileInputStreamTest1 {
    public static void main(String[] args) throws Exception {
        // 1、创建文件字节输入流管道，与源文件接通。
        // InputStream is = new FileInputStream(new File("file-io-app\\src\\itheima01.txt"));
        // 简化写法：推荐使用。
        InputStream is = new FileInputStream(("file-io-app\\src\\itheima01.txt"));

        // 2、开始读取文件的字节数据。
        // public int read():每次读取一个字节返回，如果没有数据了，返回-1.
//        int b1 = is.read();
//        System.out.println((char)b1);
//
//        int b2 = is.read();
//        System.out.println((char) b2);
//
//        int b3 = is.read();
//        System.out.println(b3);

        // 3、使用循环改造上述代码
        int b; // 用于记住读取的字节。
        while ((b = is.read()) != -1){
            System.out.print((char) b);
        }

        // 读取数据的性能很差！
        // 读取汉字输出会乱码！！无法避免的！！
        // 流使用完毕之后，必须关闭！释放系统资源！
        is.close();
    }
}
