package com.itheima.d4_enum;
// 枚举类
public enum A {
    // 常量，每个常量都是记住枚举类的一个对象的。
    X, Y, Z;

    A(){
    }

    A(String name){
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
