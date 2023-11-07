package com.itheima.d1_staticdemo;

public class Test {
    public static void main(String[] args) {
        // 目标：掌握有无static修饰成员变量的用法，特点。
        // 1、类变量的用法。
        // 类名.类变量（推荐）
        Student.name = "袁华";

        // 对象.类变量（不推荐）
        Student s1 = new Student();
        s1.name = "马冬梅";

        Student s2 = new Student();
        s2.name = "秋雅";

        System.out.println(s1.name); // 秋雅
        System.out.println(Student.name); // 秋雅

        // 2、实例变量的用法：属于每个对象的变量
        // 对象.实例变量
        s1.age = 23;
        s2.age = 18;
        System.out.println(s1.age); // 23

        // System.out.println(Student.age); // 报错
    }
}
