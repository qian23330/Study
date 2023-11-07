package com.itheima.d1_inner_class1;

public class Test {
    public static void main(String[] args) {
        // 目标：了解成员内部类和其特点。
        Outer.Inner in = new Outer().new Inner();
        in.test();
    }
}
