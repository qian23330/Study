package com.itheima.thisdemo;

public class Student {
    String name;
    double score;
    public void test(Student this){
        System.out.println(this);
    }

    public void printPass(double score){
        if(this.score >= score){
            System.out.println("恭喜您，您成功考入了哈佛大学~~");
        }else {
            System.out.println("很遗憾，您没有考过~~");
        }
    }
}
