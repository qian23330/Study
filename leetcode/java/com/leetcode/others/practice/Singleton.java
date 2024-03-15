package com.leetcode.others.practice;

public class Singleton {
    // 使用 volatile 保证多线程环境下的可见性
    private static volatile Singleton instance;

    // 私有化构造函数，防止其他代码创建实例
    private Singleton() {
        System.out.println("对象已创建...");
    }

    // 公开的获取实例的方法，使用双重检查锁定确保只创建一个实例
    public static Singleton getInstance() {
        if (instance == null) { // 第一次检查
            synchronized (Singleton.class) {  // 获取锁
                if (instance == null) {  // 第二次检查
                    instance = new Singleton();  // 创建实例
                }
            }
        }
        return instance;  // 返回单例
    }

    public static void main(String[] args) {
        Singleton ql = Singleton.getInstance();
        System.out.println(ql.getClass());
    }
}
