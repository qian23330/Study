package com.itheima.d7_method_references;

/**
 *  目标：构造器引用(理解语法)
 */
public class Test3 {
    public static void main(String[] args) {
        // 1、创建这个接口的匿名内部类对象。
//        CreateCar cc = new CreateCar(){
//            @Override
//            public Car create(String name, double price) {
//                return new Car(name, price);
//            }
//        };

        // CreateCar cc = ( name,  price) -> new Car(name, price);

        // 构造器引用
        CreateCar cc = Car::new;
        Car c = cc.create("奔驰", 49.9);
        System.out.println(c);
    }
}

interface CreateCar{
    Car create(String name, double price);
}