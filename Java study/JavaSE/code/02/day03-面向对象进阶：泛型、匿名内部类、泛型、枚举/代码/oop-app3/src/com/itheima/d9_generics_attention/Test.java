package com.itheima.d9_generics_attention;

import java.math.BigDecimal;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        // 目标：理解泛型的注意事项。
        // 1、泛型是工作在编译阶段的，一旦程序编译成class文件，class文件中就不存在泛型了，这就是泛型擦除。
        ArrayList<String> list = new ArrayList<>();
        list.add("java1");
        list.add("java2");
        list.add("java3");
        String rs = list.get(2);
        System.out.println(rs);

        // 2、泛型不支持基本数据类型，只能支持对象类型（引用数据类型）。
//        ArrayList<int> list1 = new ArrayList<>();
//        ArrayList<double> list2 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(12);

        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(23.3);

        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        System.out.println(a);
        BigDecimal a1 = new BigDecimal(0.1);
    }
}
