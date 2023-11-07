package com.itheima.variable;

public class TypeDemo1 {
    public static void main(String[] args) {
        // 目标：掌握8种基本数据类型，用来定义变量。
        // 1、整型
        byte number = 98;
        System.out.println(number);

        short number2 = 9000;

        int number3 = 12323232; // 默认

        // 注意：随便写一个整型字面量，默认是int类型的，73642422442424虽然没有超过long的范围，但是它超过了本身int的范围了。
        // 如果希望随便写一个整型字面量是long类型的，需要在其后面加上L/l
        long number4 = 73642422442424L;

        // 2、浮点型
        // 注意：随便写一个小数字面量，默认当成double类型对待的，如果希望这个小数是float类型的，需要在后面加上：F/f
        float score1 = 99.5F;
        double score2 = 99.8; // 默认定义方案。

        // 3、字符型
        char ch1 = 'a';
        char ch2 = '中';
        char ch3 = '国';

        // 4、布尔型
        boolean b1 = true;
        boolean b2 = false;

        // 引用数据类型：String.
        // String代表的是字符串类型，定义的变量可以用来记住字符串。
        String name = "黑马";
        System.out.println(name);
    }
}
