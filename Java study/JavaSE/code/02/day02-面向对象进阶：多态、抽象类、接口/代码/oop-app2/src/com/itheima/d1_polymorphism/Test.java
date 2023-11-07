package com.itheima.d1_polymorphism;

public class Test {
    public static void main(String[] args) {
        // 目标：认识多态：对象多态，行为多态。
        // 1、对象多态
        People p1 = new Teacher();
        p1.run(); // 识别技巧：编译看左边，运行看右边
        System.out.println(p1.name);  // 注意：对于变量，编译看左边，运行看左边

        People p2 = new Student();
        p2.run(); // 识别技巧：编译看左边，运行看右边
        System.out.println(p2.name); // 注意：对于变量，编译看左边，运行看左边
    }
}
