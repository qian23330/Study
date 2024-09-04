package com.leetcode.hot100.哈希.leetcode0316;

/*
力扣-316-去除重复字母
哈希
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        for (char c : s.toCharArray()) {
            map.merge(c, -1, Integer::sum);
            if (!set.add(c)) {
                continue;
            }
            while (!res.isEmpty() && c < res.charAt(res.length() - 1) && map.get(res.charAt(res.length() - 1)) > 0) {
                set.remove(res.charAt(res.length() - 1));
                res.deleteCharAt(res.length() - 1);
            }
            res.append(c);
        }
        return res.toString();
    }
}
