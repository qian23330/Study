package com.itheima.variable;

public class Student {
    // 成员变量（对象的属性，Field）
    String name;
    double score;

    public void aaa(){
        double score = 98;
        System.out.println(score);
        System.out.println(this.score);
    }
}
