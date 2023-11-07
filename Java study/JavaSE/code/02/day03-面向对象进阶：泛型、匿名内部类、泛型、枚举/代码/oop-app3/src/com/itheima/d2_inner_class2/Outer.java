package com.itheima.d2_inner_class2;

public class Outer {
    private int age = 99;
    public static String schoolName;
    // 静态内部类
    public static class Inner{
        private String name;
        public static int a;
        private int age = 88;

        public void test(){
            System.out.println(schoolName);
            // System.out.println(age);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void test2(){
        System.out.println(schoolName);
        // System.out.println(age);
    }
}
