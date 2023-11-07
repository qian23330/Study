package com.itheima.d3_exception;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 目标：异常的处理
 */
public class ExceptionTest3_2 {
    public static void main(String[] args)  {
        try {
            test1();
        } catch (Exception e) {
            System.out.println("您当前操作有问题");
            e.printStackTrace(); // 打印出这个异常对象的信息。记录下来。
        }
    }

    public static void test1() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse("2028-11-11 10:24:11");
        System.out.println(d);
        test2();
    }

    public static void test2() throws Exception {
        // 读取文件的。
        InputStream is = new FileInputStream("D:/meinv.png");
    }
}
