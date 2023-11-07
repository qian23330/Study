package com.itheima.d8_extends_application;

public class Test {
    public static void main(String[] args) {
        // 目标：搞清楚继承的好处。
        Teacher t = new Teacher();
        t.setName("播仔");
        t.setSkill("Java、Spring");
        System.out.println(t.getName());
        System.out.println(t.getSkill());
        t.printInfo();
    }
}
