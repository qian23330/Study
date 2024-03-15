package com.leetcode.hot100.回溯.leetcode0131;

/*
力扣-131-分割回文串
hot100-回溯
 */

import java.util.*;

class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            } else continue;
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串s：");
        String input = scanner.nextLine();
        System.out.println(new Solution().partition(input));
    }
}
