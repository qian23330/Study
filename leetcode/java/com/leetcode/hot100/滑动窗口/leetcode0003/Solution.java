package com.leetcode.hot100.滑动窗口.leetcode0003;

/*
力扣-3-无重复字符的最长子串
hot100-滑动窗口-哈希
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, i = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c));
            }
            map.put(c, j);
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
