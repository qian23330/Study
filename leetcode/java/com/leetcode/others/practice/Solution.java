package com.leetcode.others.practice;

/*
力扣
practice-练习
 */


import java.util.*;

class Solution {
    /*
    lc 159 至少包含两个不同字符的最长子串
    滑动窗口/哈希
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), uniqCnt = 0, start = 0;
        int len = 0, startIndex = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                uniqCnt++;
            }
            while (uniqCnt > 2) {
                char t = s.charAt(start);
                map.put(t, map.get(t) - 1);
                if (map.get(t) == 0) {
                    uniqCnt--;
                }
                start++;
            }
            if (i - start + 1 > len) {
                len = i - start + 1;
                startIndex = start;
            }
        }
        System.out.println(s.substring(startIndex, len + startIndex));
    }
}

