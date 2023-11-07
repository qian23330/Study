package com.itheima.d7_extends;
// 子类
public class B extends A{
    private int k;
    // 子类是可以继承父类的非私有成员
    public void print3(){
        System.out.println(i);
        print1();

        // System.out.println(j);
        // print2();
    }
}
