package com.itheima.constructor;

public class Student {
    String name;
    double score;
    // 无参数构造器
    public Student(){
        System.out.println("无参数构造器被触发执行了~");
    }

    // 有参数构造器
    public Student(String name, double score){
        System.out.println("有参数构造器被触发执行了~~");
        this.name = name;
        this.score = score;
    }
}
