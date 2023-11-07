package com.itheima.encapsulation;

public class Student {
    public double score;

    private void printPass(){
        System.out.println(score >= 60 ? "成绩及格" :  "成绩不及格");
    }
}