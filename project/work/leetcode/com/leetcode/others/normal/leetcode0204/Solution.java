package com.leetcode.others.normal.leetcode0204;

/*
力扣-204-计数质数
normal-埃氏筛
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                res += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("请输入整数n：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new Solution().countPrimes(n));
    }
}
