package com.leetcode.others.normal.leetcode0415;

import java.util.Scanner;

/*
力扣-415-字符串相加
normal-数学运算
 */

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串，一行一个：");
        String nums1 = scanner.nextLine();
        String nums2 = scanner.nextLine();
        System.out.println(new Solution().addStrings(nums1, nums2));
    }
}
