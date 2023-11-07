package com.itheima.literal;

public class LiteralDemo {
    public static void main(String[] args) {
        // 目标：学会常见字面量数据在程序中的书写格式。
        // 1、整数、小数
        System.out.println(666);
        System.out.println(3.14);

        // 2、字符：加单引号，有且仅能有一个字符
        System.out.println('a');
        System.out.println('A');
        System.out.println('0');
        System.out.println('中');
        //System.out.println('中国'); // 报错的
        //System.out.println(''); // 报错的
        System.out.println(' ');
        // 注意：几个特殊字符
        System.out.println('a');
        System.out.println('\n'); // \n代表换行
        System.out.println('a');
        System.out.println('\t'); // \t代表一个tab

        // 3、字符串：加双引号，里面的内容可以随便写
        System.out.println("");
        System.out.println("    ");
        System.out.println("黑马程序员");
        System.out.println("我爱您中国 abc 1234324 ");

        // 4、布尔值：true , false
        System.out.println(true);
        System.out.println(false);
    }
}
