package com.leetcode.hot100.动态规划.leetcode0005;

/*
力扣-5-最长回文子串
hot100-动态规划
 */

import java.util.Scanner;

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();  // 提高效率
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;  // j - i + 1 = L
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {  // j - i + 1 < 4
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        System.out.println("请输入字符串s：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().longestPalindrome(s));
    }
}
