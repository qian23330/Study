package com.itheima.javabean;

public class Test {
    public static void main(String[] args) {
        // 目标：掌握实体类的书写要求、特点、应用场景。
        Student s1 = new Student();
        s1.setName("播妞");
        s1.setScore(99);
        System.out.println(s1.getName());
        System.out.println(s1.getScore());

        StudentOperator operator = new StudentOperator(s1);
        operator.printPass();
    }
}
