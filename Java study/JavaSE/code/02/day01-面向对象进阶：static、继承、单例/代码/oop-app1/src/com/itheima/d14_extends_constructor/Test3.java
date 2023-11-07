package com.itheima.d14_extends_constructor;

public class Test3 {
    public static void main(String[] args) {
        // 目标：掌握在类的构造器中，通过this(...)调用兄弟构造器的作用。
        Student s1 = new Student("李四", 26, "家里蹲大学");

        // 需求：如果学生没有填写学校，那么学校默认就是黑马程序员
        Student s2 = new Student("张三", 28);
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
        System.out.println(s2.getSchoolName());
    }
}

class Student{
    private String name;
    private int age;
    private String schoolName;

    public Student() {
    }

    public Student(String name, int age){
       this(name, age, "黑马程序员");
    }

    public Student(String name, int age, String schoolName) {
        super();
        this.name = name;
        this.age = age;
        this.schoolName = schoolName;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}