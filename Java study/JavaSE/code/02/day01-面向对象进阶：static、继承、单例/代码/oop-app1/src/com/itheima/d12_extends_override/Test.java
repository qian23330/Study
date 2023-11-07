package com.itheima.d12_extends_override;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // 目标：认识方法重写，掌握方法重写的常见应用场景。
        B b =  new B();
        b.print1();
        b.print2(2, 3);

        System.out.println("------------------------");
        Student s = new Student("播妞", 19);
        // System.out.println(s.toString());
        System.out.println(s);

        ArrayList list = new ArrayList();
        list.add("java");
        System.out.println(list);
    }
}
