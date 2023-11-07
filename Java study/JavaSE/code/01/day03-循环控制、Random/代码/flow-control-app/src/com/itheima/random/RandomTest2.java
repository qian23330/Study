package com.itheima.random;

import java.util.Random;
import java.util.Scanner;

public class RandomTest2 {
    public static void main(String[] args) {
        // 1、随机产生一个1-100之间的数据，做为中奖号码。
        Random r = new Random();
        int luckNumber = r.nextInt(100) + 1;

        // 2、定义一个死循环，让用户不断的猜测数据
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 提示用户猜测
            System.out.println("请您输入您猜测的数据：");
            int guessNumber = sc.nextInt();

            // 3、判断用户猜测的数字与幸运号码的大小情况
            if(guessNumber > luckNumber){
                System.out.println("您猜测的数字过大~~");
            }else if(guessNumber < luckNumber){
                System.out.println("您猜测的数字过小~~");
            }else {
                System.out.println("恭喜您，猜测成功了，可以买单了~~");
                break; // 结束死循环
            }
        }
    }
}
