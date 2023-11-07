package com.itheima.d4_print_stream;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * 目标：掌握打印流：PrintStream/PrintWriter的用法。
 */
public class PrintTest1 {
    public static void main(String[] args) {
        try (
                // 1、创建一个打印流管道
//                PrintStream ps =
//                        new PrintStream("io-app2/src/itheima08.txt", Charset.forName("GBK"));
//                PrintStream ps =
//                        new PrintStream("io-app2/src/itheima08.txt");
                PrintWriter ps =
                        new PrintWriter(new FileOutputStream("io-app2/src/itheima08.txt", true));
                ){
                ps.println(97);
                ps.println('a');
                ps.println("我爱你中国abc");
                ps.println(true);
                ps.println(99.5);

                // ps.write(97); // 'a'

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
