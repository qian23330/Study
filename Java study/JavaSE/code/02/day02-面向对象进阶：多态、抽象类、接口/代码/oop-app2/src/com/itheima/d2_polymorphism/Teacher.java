package com.itheima.d2_polymorphism;

public class Teacher extends People {
    public String name = "子类Teacher的名称";

    @Override
    public void run() {
        System.out.println("老师跑的气喘吁吁~~");
    }

    public void teach(){
        System.out.println("老师需要教知识~~~");
    }
}
