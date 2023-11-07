package com.itheima.string;

public class StringDemo1 {
    public static void main(String[] args) {
        // 目标：掌握创建String对象，并封装要处理的字符串的两种方式。
        // 1、直接双引号得到字符串对象，封装字符串数据
        String name = "黑马666";
        System.out.println(name);

        // 2、new String创建字符串对象，并调用构造器初始化字符串
        String rs1 = new String();
        System.out.println(rs1); // ""

        String rs2 = new String("itheima");
        System.out.println(rs2);

        char[] chars = {'a', '黑', '马'};
        String rs3 = new String(chars);
        System.out.println(rs3);

        byte[] bytes = {97, 98, 99};
        String rs4 = new String(bytes);
        System.out.println(rs4);
    }
}


