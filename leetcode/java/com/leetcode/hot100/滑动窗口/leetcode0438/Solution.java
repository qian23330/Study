package com.leetcode.hot100.滑动窗口.leetcode0438;

/*
力扣-438-找到字符串中所有字母异位词
hot100-滑动窗口-哈希
 */

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.merge(p.charAt(i), 1, Integer::sum);
        }
        int left = 0, right = left;
        int valid = 0;
        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.merge(c, 1, Integer::sum);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }
                    window.merge(d, -1, Integer::sum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        System.out.println(new Solution().findAnagrams(s, p));
    }
}
