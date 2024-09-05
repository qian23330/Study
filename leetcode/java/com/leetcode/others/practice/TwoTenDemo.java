package com.leetcode.others.practice;

import java.util.Scanner;

/*
二进制十进制转换
 */
public class TwoTenDemo {
    public int binaryToDecimal(String s) {
        int decimal = 0, power = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            int digit = s.charAt(i) - '0';
            decimal += digit * Math.pow(2, power);
            power++;
        }
        return decimal;
    }

    public String decimalToBinary(int num) {
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            int remain = num % 2;
            res.append(remain);
            num /= 2;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num = scanner.nextInt();
        System.out.println(new TwoTenDemo().binaryToDecimal(s));
        System.out.println(new TwoTenDemo().decimalToBinary(num));
    }
}
