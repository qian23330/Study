package com.itheima.variable;

public class VariableDemo2 {
    public static void main(String[] args) {
        // 目标：理解变量定义的注意事项，并注意。
//        1、变量要先声明再使用
          int age = 21;
          age = 25;
          System.out.println(age);

//        2、变量声明后，不能存储其他类型的数据。
          // age = 35.9;

//        3、变量的有效范围是从定义开始到“}”截止,且在同一个范围内部不能定义2个同名的变量。
         {
             double money = 23.5;
             System.out.println(money);
             // double money = 10.4; // 报错
             // int age = 28; // 报错
         }
//         System.out.println(money); // 报错
        System.out.println(age);
        double money = 99.5;
        System.out.println(money);

//        4、变量定义的时候可以没有初始值，但是使用的时候必须给初始值。
        int number ;
        number = 100;
        System.out.println(number);
    }
}
