package com.itheima.d4_byte_stream;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 目标：掌握使用FileInputStream每次读取多个字节。
 */
public class FileInputStreamTest2 {
    public static void main(String[] args) throws Exception {
        // 1、创建一个字节输入流对象代表字节输入流管道与源文件接通。
        InputStream is = new FileInputStream("file-io-app\\src\\itheima02.txt");

        // 2、开始读取文件中的字节数据：每次读取多个字节。
        //  public int read(byte b[]) throws IOException
        //  每次读取多个字节到字节数组中去，返回读取的字节数量，读取完毕会返回-1.
//        byte[] buffer = new byte[3];
//        int len = is.read(buffer);
//        String rs = new String(buffer);
//        System.out.println(rs);
//        System.out.println("当次读取的字节数量：" + len);
//
//        // buffer = [abc]
//        // buffer = [66c]
//        int len2 = is.read(buffer);
//        // 注意：读取多少，倒出多少。
//        String rs2 = new String(buffer, 0, len2);
//        System.out.println(rs2);
//        System.out.println("当次读取的字节数量：" + len2);
//
//        int len3 = is.read(buffer);
//        System.out.println(len3); // -1

        // 3、使用循环改造。
        byte[] buffer = new byte[3];
        int len; // 记住每次读取了多少个字节。  abc 66
        while ((len = is.read(buffer)) != -1){
            // 注意：读取多少，倒出多少。
            String rs = new String(buffer, 0 , len);
            System.out.print(rs);
        }
        // 性能得到了明显的提升！！
        // 这种方案也不能避免读取汉字输出乱码的问题！！

        is.close(); // 关闭流
    }
}
