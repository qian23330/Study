package com.itheima.d4_static_attention;

public class Student {
    static String schoolName; // 类变量
    double score; // 实例变量

    // 1、类方法中可以直接访问类的成员，不可以直接访问实例成员。
    public static void printHelloWorld(){
        // 注意：同一个类中，访问类成员，可以省略类名不写。
        schoolName = "黑马";
        printHelloWorld2();

        // System.out.println(score); // 报错的
        // printPass(); // 报错的

        // System.out.println(this); // 报错的
    }

    // 类方法
    public static void printHelloWorld2(){

    }

    // 2、实例方法中既可以直接访问类成员，也可以直接访问实例成员。
    // 实例方法
    // 3、实例方法中可以出现this关键字，类方法中不可以出现this关键字的
    public void printPass(){
        schoolName = "黑马2";
        printHelloWorld2();

        System.out.println(score);
        printPass2();

        System.out.println(this);
    }

    // 实例方法
    public void printPass2(){

    }
}
