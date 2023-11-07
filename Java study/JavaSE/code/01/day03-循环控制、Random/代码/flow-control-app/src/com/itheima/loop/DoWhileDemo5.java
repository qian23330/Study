package com.itheima.loop;

public class DoWhileDemo5 {
    public static void main(String[] args) {
        // 目标：掌握do-while循环的书写格式，执行流程，特点和应用场景。
        // 需求：打印多行Hello World
        int i = 0;
        do{
            System.out.println("Hello World");
            i++;
        }while (i < 3);

        // 特点：先执行后判断
        do{
            System.out.println("Hello World2");
        }while (false);

        System.out.println("------------------------------------------------------");

        for (int j = 0; j < 3; j++) {
            System.out.println("Hello World3");
        }
        // System.out.println(j);
        for (int j = 0; j < 3; j++) {
            System.out.println("Hello World3");
        }

        int m = 0;
        while (m < 3){
            System.out.println("Hello World4");
            m++;
        }
        System.out.println(m); // 3
    }
}
