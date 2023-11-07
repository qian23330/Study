package com.itheima.d6_lambda;

import com.itheima.d5_arrays.Student;
import java.util.Arrays;

public class LambdaTest2 {
    public static void main(String[] args) {
        // 目标：使用Lambda简化函数式接口。
        double[] prices = {99.8, 128, 100};

//        Arrays.setAll(prices, new IntToDoubleFunction() {
//            @Override
//            public double applyAsDouble(int value) {
//                // value = 0  1  2
//                return prices[value] * 0.8;
//            }
//        });

//        Arrays.setAll(prices, (int value) -> {
//                return prices[value] * 0.8;
//        });

//        Arrays.setAll(prices, (value) -> {
//            return prices[value] * 0.8;
//        });

//        Arrays.setAll(prices, value -> {
//            return prices[value] * 0.8;
//        });

        Arrays.setAll(prices, value -> prices[value] * 0.8 );

        System.out.println(Arrays.toString(prices));
        System.out.println("----------------------------------------------------------");

        Student[] students = new Student[4];
        students[0] = new Student("蜘蛛精", 169.5, 23);
        students[1] = new Student("紫霞", 163.8, 26);
        students[2] = new Student("紫霞", 163.8, 26);
        students[3] = new Student("至尊宝", 167.5, 24);

//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return Double.compare(o1.getHeight(), o2.getHeight()); // 升序
//            }
//        });

//        Arrays.sort(students, (Student o1, Student o2) -> {
//                return Double.compare(o1.getHeight(), o2.getHeight()); // 升序
//        });

//        Arrays.sort(students, ( o1,  o2) -> {
//            return Double.compare(o1.getHeight(), o2.getHeight()); // 升序
//        });

        Arrays.sort(students, ( o1,  o2) -> Double.compare(o1.getHeight(), o2.getHeight()));


        System.out.println(Arrays.toString(students));
    }
}
