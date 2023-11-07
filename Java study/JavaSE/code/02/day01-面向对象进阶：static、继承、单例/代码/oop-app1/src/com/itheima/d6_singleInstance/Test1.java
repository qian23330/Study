package com.itheima.d6_singleInstance;

public class Test1 {
    public static void main(String[] args) {
        // 目标：掌握单例设计模式的写法。
        A a1 = A.getObject();
        A a2 = A.getObject();
        System.out.println(a1);
        System.out.println(a2);
    }
}
