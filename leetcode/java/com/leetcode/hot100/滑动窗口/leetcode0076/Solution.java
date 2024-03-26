package com.leetcode.hot100.滑动窗口.leetcode0076;

/*
力扣-76-最小覆盖子串
hot100-滑动窗口-哈希
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.merge(t.charAt(i), 1, Integer::sum);
        }
        int needCnt = need.size();
        int[] minRes = new int[]{0, Integer.MAX_VALUE};
        int len = s.length();
        for (int i = 0, j = 0; j < len; j++) {
            char c = s.charAt(j);
            if (need.getOrDefault(c, 0) > 0) needCnt--;
            need.merge(c, -1, Integer::sum);
            if (needCnt == 0) {
                while (true) {
                    c = s.charAt(i);
                    if (need.get(c) == 0) break;
                    need.merge(c, 1, Integer::sum);
                    i++;
                }
                if (j - i < minRes[1] - minRes[0]) {
                    minRes[1] = j;
                    minRes[0] = i;
                }
                c = s.charAt(i);
                need.merge(c, 1, Integer::sum);
                needCnt++;
                i++;
            }
        }
        return minRes[1] > len ? "" : s.substring(minRes[0], minRes[1] + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(new Solution().minWindow(s, t));
    }
}
