package com.leetcode.others.normal.字符串.leetcode0151;

/*
力扣-151-反转字符串中的单词
normal-字符串-双指针
 */

import java.util.Scanner;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {  // 搜索首个空格
                i--;
            }
            res.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {  // 跳过单词间空格
                i--;
            }
            j = i;  // j 指向下个单词的尾字符
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().reverseWords(s));
    }
}
