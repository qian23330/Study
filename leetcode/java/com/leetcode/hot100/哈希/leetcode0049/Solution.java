package com.leetcode.hot100.哈希.leetcode0049;

/*
力扣-49-字母异位词分组
hot100-哈希
*/

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String newstr = new String(array);
            List<String> list = map.getOrDefault(newstr, new ArrayList<>());
            list.add(str);
            map.put(newstr, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        System.out.println(new Solution().groupAnagrams(strs));
    }
}
