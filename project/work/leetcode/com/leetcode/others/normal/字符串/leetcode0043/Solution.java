package com.leetcode.others.normal.字符串.leetcode0043;

/*
力扣-43-字符串相乘
normal-数学运算
 */

import java.util.Scanner;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder cur = new StringBuilder();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                cur.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                cur.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                cur.append(add % 10);
            }
            res = addStrings(res, cur.reverse().toString());
        }
        return res;
    }

    private String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();
        System.out.println(new Solution().multiply(num1, num2));
    }
}
