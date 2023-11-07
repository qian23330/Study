package com.itheima.d7_method_references;

import com.itheima.d5_arrays.Student;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  目标：了解静态方法引用、实例方法引用，简化Lambda表达式。
 */
public class Test1 {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("蜘蛛精", 169.5, 23);
        students[1] = new Student("紫霞", 163.8, 26);
        students[2] = new Student("紫霞", 163.8, 26);
        students[3] = new Student("至尊宝", 167.5, 24);

        // 原始写法：对数组中的学生对象，按照年龄升序排序
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge(); // 按照年龄升序排序
//            }
//        });

        // 使用Lambda简化后的形式
        // Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());

        // Arrays.sort(students, (o1, o2) -> CompareByData.compareByAge(o1, o2));

        // 静态方法引用
        // Arrays.sort(students,  CompareByData::compareByAge);
        System.out.println("--------------------------------------------------------------");

        // Arrays.sort(students, (o1, o2) -> o2.getAge() - o1.getAge()); // 降序

        CompareByData compare = new CompareByData();
        // Arrays.sort(students, (o1, o2) -> compare.compareByAgeDesc(o1, o2)); // 降序
        // 实例方法引用
        Arrays.sort(students, compare::compareByAgeDesc); // 降序

        System.out.println(Arrays.toString(students));
    }
}
