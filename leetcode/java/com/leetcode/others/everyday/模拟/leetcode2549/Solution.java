package com.leetcode.others.everyday.模拟.leetcode2549;

/*
力扣-2549-统计桌面上的不同数字
每日一题-24.03.23-模拟
*/

import java.util.Scanner;

class Solution {
    public int distinctIntegers(int n) {
        return Math.max(n - 1, 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new Solution().distinctIntegers(n));
    }
}
