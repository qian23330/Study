package com.itheima.loop;

public class WhileTest4 {
    public static void main(String[] args) {
        // 目标：使用while循环解决问题，并理解什么情况下使用while，for。
        // 1、定义变量记住珠穆朗玛峰的高度和纸张的高度。
        double peakHeight = 8848860;
        double paperThickness = 0.1;

        // 3、定义一个变量count用于记住纸张折叠了多少次
        int count = 0;

        // 2、定义while循环控制纸张开始折叠
        while (paperThickness < peakHeight) {
            // 把纸张进行折叠，把纸张的厚度变成原来的2倍。
            paperThickness = paperThickness * 2;
            count++;
        }
        System.out.println("需要折叠多少次：" + count);
        System.out.println("最终纸张的厚度是：" + paperThickness);

    }
}
