package com.itheima.type;

public class TypeConversionDemo1 {
    public static void main(String[] args) {
        // 目标：理解自动类型转换机制。
        byte a = 12;
        int b = a; // 发生了自动类型转换了
        System.out.println(a);
        System.out.println(b);

        int c = 100; // 4
        double d = c;// 8 发生了自动类型转换了
        System.out.println(d);

        char ch = 'a'; // 'a' 97 => 00000000 01100001
        int i = ch; // 发生了自动类型转换了 =>  00000000 00000000  00000000 01100001
        System.out.println(i);
    }
}
