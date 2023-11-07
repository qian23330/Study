package com.itheima.loop;

public class ForDemo2 {
    public static void main(String[] args) {
        // 目标：掌握使用for循环批量产生数据。
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }

        System.out.println("=========================================");

        // 2、定义一个变量用于求和
        int sum = 0; // 15

        // 1、定义一个循环，先产生1-100，这100个数
        for (int i = 1; i <= 100; i++) {
            // i = 1 2 3 4 5
            sum += i; //sum = sum  + i;
        }
        System.out.println("1-100的数据和：" +  sum);

        System.out.println("=========================================");

        // 2、定义一个变量用于求和
        int sum1 = 0;

        // 1、定义一个循环产生1-100之间的奇数
        for (int i = 1; i < 100; i+=2) {
            // i = 1 3 5 7 ...
            sum1 += i;
        }
        System.out.println("1-100之间的奇数和：" +  sum1);

        System.out.println("=========================================");

        // 2、定义一个变量用于累加奇数求和
        int sum2 = 0; // 4

        // 1、定义循环产生1-100之间的每个数据
        for (int i = 1; i <= 100; i++) {
            // i = 1 2 3 4 5 6 ... 99 100
            // 2、使用一个if分支，判断i此时记住的数据是否是奇数，是奇数我们才累加给一个变量
            if(i % 2 == 1){
                // i = 1 3 5 7 9 ... 99
                sum2 += i;
            }
        }
        System.out.println("1-100之间的奇数和：" + sum2);
    }
}
