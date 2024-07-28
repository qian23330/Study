package com.leetcode.hot100.动态规划.leetcode0005;

/*
力扣-5-最长回文子串
hot100-动态规划 / 中心扩散
 */

import java.util.Scanner;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0, end = start;
        for (int i = 0; i < s.length(); i++) {
            int len1 = findLength(s, i, i);
            int len2 = findLength(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int findLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println("请输入字符串s：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().longestPalindrome(s));
    }
}
