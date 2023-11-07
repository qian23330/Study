package com.itheima.d13_stringBuilder;

public class Test2 {
    public static void main(String[] args) {
        // 目标：掌握StringBuilder的好处。
        // 需求：要拼接100万次abc
        // 先用String测试看看性能
//        String rs = "";
//        for (int i = 1; i <= 1000000 ; i++) {
//            rs = rs + "abc";
//        }
//        System.out.println(rs);

        // 使用StringBuilder演示
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 1000000; i++) {
            sb.append("abc");
        }
        System.out.println(sb);
    }
}
