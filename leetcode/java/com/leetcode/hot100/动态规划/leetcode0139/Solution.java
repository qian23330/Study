package com.leetcode.hot100.动态规划.leetcode0139;

/*
力扣-139-单词拆分
hot100-动态规划-完全背包
 */

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {  // 排列问题-先背包，后物品
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        List<String> wordDict = new ArrayList<>(List.of(input));
        System.out.println(new Solution().wordBreak(s, wordDict));
    }
}
