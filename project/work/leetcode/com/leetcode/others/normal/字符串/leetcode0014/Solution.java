package com.leetcode.others.normal.字符串.leetcode0014;

/*
力扣-14-最长公共前缀
normal-字符串
 */

import java.util.Scanner;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        System.out.println(new Solution().longestCommonPrefix(input));
    }
}
