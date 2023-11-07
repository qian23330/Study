package com.itheima.d6_abstract_template;

public class Test {
    public static void main(String[] args) {
        // 目标：搞清楚抽象类的应用场景之一：经常用来设计模板方法设计模式。
        // 场景：
        //          学生，老师都要写一篇作文：我的爸爸
        //              第一段是一样的
        //              正文部分自由发挥
        //              最后一段也是一样的。
        Teacher t = new Teacher();
        t.write();

        Student s = new Student();
        s.write();
    }
}
