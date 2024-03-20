package com.leetcode.others.normal.数学.leetcode0050;

/*
力扣-50-Pow(x, n)
normal-快速幂
 */

import java.util.Scanner;

class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();
        System.out.println(new Solution().myPow(x, n));
    }
}
