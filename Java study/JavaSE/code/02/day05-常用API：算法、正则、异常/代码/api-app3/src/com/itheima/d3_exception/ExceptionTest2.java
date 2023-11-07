package com.itheima.d3_exception;

/**
 * 目标：掌握自定义异常，以及异常的作用。
 */
public class ExceptionTest2 {
    public static void main(String[] args) {
        // 需求：保存一个合法的年龄
//        try {
//            saveAge(223);
//            System.out.println("底层执行成功的！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("底层出现了bug!");
//        }

        try {
            saveAge2(225);
            System.out.println("saveAge2底层执行是成功的！");
        } catch (AgeIllegalException e) {
            e.printStackTrace();
            System.out.println("saveAge2底层执行是出现bug的！");
        }
    }

    public static void saveAge2(int age) throws AgeIllegalException{
        if(age > 0 && age < 150){
            System.out.println("年龄被成功保存： " + age);
        }else {
            // 用一个异常对象封装这个问题
            // throw 抛出去这个异常对象
            // throws 用在方法上，抛出方法内部的异常
            throw new AgeIllegalException("/age is illegal, your age is " + age);
        }
    }

    public static void saveAge(int age){
        if(age > 0 && age < 150){
            System.out.println("年龄被成功保存： " + age);
        }else {
            // 用一个异常对象封装这个问题
            // throw 抛出去这个异常对象
            throw new AgeIllegalRuntimeException("/age is illegal, your age is " + age);
        }
    }
}
