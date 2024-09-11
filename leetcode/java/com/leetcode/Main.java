package com.leetcode;

public class Main {
    public int convert(String s) {
        int res = 0;
        if (s.isEmpty() || s == null) System.out.println("非法输入，请输入二进制数");
        for (char c : s.toCharArray()) {
            if (c != '0' && c != '1') {
                System.out.println("非法输入，请输入二进制数");
                break;
            }
        }
        for (char c : s.toCharArray()) {
            res = (res << 1) | (c - '0');
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "01001";
        System.out.println(new Main().convert(s));
    }
}
