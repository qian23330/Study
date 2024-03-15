package com.leetcode.others.everyday.字符串.leetcode2575;

/*
力扣-2575-找出字符串的可整除数组
每日一题-24.03.07-字符串
*/

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] divisibilityArray(String word, int m) {
        int len = word.length();
        int[] div = new int[len];
        long cur = 0;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            cur = (cur * 10 + (c - '0')) % m;
            div[i] = (cur == 0) ? 1 : 0;
        }
        return div;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int m = scanner.nextInt();
        System.out.println(Arrays.toString(new Solution().divisibilityArray(word, m)));
    }
}
