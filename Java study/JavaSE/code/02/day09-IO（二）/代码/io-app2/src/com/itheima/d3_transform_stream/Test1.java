package com.itheima.d3_transform_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 * 目标：掌握不同编码读取乱码的问题。
 */
public class Test1 {
    public static void main(String[] args) {
        try (
                // 1、创建一个文件字符输入流与源文件接通
                // 代码编码：UTF-8  文件的编码：UTF-8
                // Reader fr = new FileReader("io-app2/src/itheima04.txt");

                //         1 床    前     明  月光c
                //  GBK    o [oo] [oo]  [oo] ...
                //  UTF-8  1 ?????
                // 代码编码：UTF-8 文件的编码：GBK
                Reader fr = new FileReader("io-app2/src/itheima06.txt");
                // 2、把文件字符输入流包装成缓冲字符输入流
                BufferedReader br = new BufferedReader(fr);
                ){

            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
