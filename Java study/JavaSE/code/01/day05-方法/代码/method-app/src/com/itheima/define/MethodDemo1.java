package com.itheima.define;

public class MethodDemo1 {
    public static void main(String[] args) {
        // 目标：掌握定义方法的完整格式，搞清楚使用方法的好处。
        // 需求：假如现在很多程序员都要进行2个整数求和的操作。

        // 1、李工。
        int rs = sum(10, 20);
        System.out.println("和是：" + rs);

        // 2、张工。
        int rs2 = sum(30, 20);
        System.out.println("和是：" + rs2);
    }

    public static int sum(int a,int b) {
        int c = a + b;
        return c;
    }
}
