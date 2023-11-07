package com.itheima.d3_inner_class3;

public class Test {
    public static void main(String[] args) {
        // 目标：认识匿名内部类，并掌握其作用。
//        Animal a = new Cat();
//        a.cry();

        // 1、把这个匿名内部类编译成一个子类，然后会立即创建一个子类对象出来。
        Animal a = new Animal(){
            @Override
            public void cry() {
                System.out.println("猫喵喵喵的叫~~~");
            }
        };
        a.cry();
    }
}

//class Cat extends Animal{
//    @Override
//    public void cry() {
//        System.out.println("猫喵喵喵的叫~~~");
//    }
//}

abstract class Animal{
    public abstract void cry();
}