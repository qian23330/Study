package com.itheima.d6_generics_class;

public class Test {
    public static void main(String[] args) {
        // 目标：掌握泛型类的定义和使用。
        MyArrayList<String> list = new MyArrayList<>();
        list.add("java1");
        list.add("java2");
        String ele = list.get(1);
        System.out.println(ele);

        MyClass2<Cat, String> c2 = new MyClass2<>();

        // MyClass3<String> c3 = new MyClass3<>(); // 报错
        MyClass3<Animal> c4 = new MyClass3<>();
        MyClass3<Dog> c5 = new MyClass3<>();
    }
}


