package com.itheima.operator;

public class OperatorDemo3 {
    public static void main(String[] args) {
        // 目标：掌握扩展赋值运算符的使用。
        // +=
        // 需求：收红包
        double a = 9.5;
        double b = 520;
        a += b;  // a = (double)(a + b);
        System.out.println(a);

        // -= 需求：发红包
        double i = 600;
        double j = 520;
        i -= j;  // i = (double)(i - j);
        System.out.println(i);

        int m = 10;
        int n = 5;
        // m *= n; // 等价形式： m = (int)(m * n)
        // m /= n; // 等价形式： m = (int)(m / n)
        m %= n;    // 等价形式： m = (int)(m % n)
        System.out.println(m);

        System.out.println("-------------------------------------------------");

        byte x = 10;
        byte y = 30;
        //  x = x + y; // 编译报错
        // x = (byte)(x + y);
        x += y; // 等价形式：x = (byte)(x + y);
        System.out.println(x);
    }
}
