package com.leetcode.hot100.回溯.leetcode0017;

/*
力扣-17-电话号码的字母组合
hot100-回溯
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    String[] letterMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder s = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int index) {
        if (index == digits.length()) {
            res.add(s.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = letterMap[digit];
        for (char c : letters.toCharArray()) {
            s.append(c);
            backtracking(digits, index + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        System.out.println(new Solution().letterCombinations(digits));
    }
}
