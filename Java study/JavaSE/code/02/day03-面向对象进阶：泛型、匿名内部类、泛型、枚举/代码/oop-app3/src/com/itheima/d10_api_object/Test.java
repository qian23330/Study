package com.itheima.d10_api_object;

public class Test {
    public static void main(String[] args) {
        // 目标：掌握Object类提供的常用方法。
        Student s1 = new Student("赵敏", 23);
        // System.out.println(s1.toString());
        System.out.println(s1);

        Student s2 = new Student("赵敏", 23);
        System.out.println(s2.equals(s1));
        System.out.println(s2 == s1);
    }
}












