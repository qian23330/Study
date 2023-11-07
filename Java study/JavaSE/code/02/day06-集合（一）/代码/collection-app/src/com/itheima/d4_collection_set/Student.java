package com.itheima.d4_collection_set;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double height;

    // this  o
    @Override
    public int compareTo(Student o) {
        // 如果认为左边对象大于右边对象返回正整数
        // 如果认为左边对象小于右边对象返回负整数
        // 如果认为左边对象等于右边对象返回0
        // 需求：按照年龄升序排序、
        return this.age - o.age;
    }

    public Student() {
    }

    public Student(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    // 只要两个对象内容一样就返回true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Double.compare(student.height, height) == 0 && Objects.equals(name, student.name);
    }

    // 只要两个对象内容一样，返回的哈希值就是一样的。
    @Override
    public int hashCode() {
        // 姓名 年龄 身高计算哈希值的
        return Objects.hash(name, age, height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
