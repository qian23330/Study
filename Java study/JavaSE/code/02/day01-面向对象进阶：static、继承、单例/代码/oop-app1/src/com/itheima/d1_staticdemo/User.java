package com.itheima.d1_staticdemo;

public class User {
    // 类变量
    public static int number;

    public User(){
        // User.number++;
        // 注意：在同一个类中，访问自己类的类变量，才可以省略类名不写。
        number++;
    }
}
