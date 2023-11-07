package com.itheima.operator;

public class OperatorDemo2 {
    public static void main(String[] args) {
        // 目标：掌握自增自减运算符的使用。
        int a = 10;
        // a++; // a = a + 1
        ++a;
        System.out.println(a);

        // a--; // a = a - 1
        --a;
        System.out.println(a);

        // System.out.println(2++); // 自增自减只能操作变量不能操作字面量的，会报错！

        System.out.println("-------------------------------------------------");

        int i = 10;
        int rs = ++i; // 先加后用
        System.out.println(rs);
        System.out.println(i);

        int j = 10;
        int rs2 = j++; // 先用后加
        System.out.println(rs2);
        System.out.println(j);

    }
}
