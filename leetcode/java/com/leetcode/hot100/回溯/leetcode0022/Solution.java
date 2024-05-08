package com.leetcode.hot100.回溯.leetcode0022;

/*
力扣-22-括号生成
hot100-回溯
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n);
        return res;
    }

    private void backtracking(int left, int right, int max) {
        if (path.length() == 2 * max) {
            res.add(path.toString());
            return;
        }
        if (left < max) {
            path.append('(');
            backtracking(left + 1, right, max);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(')');
            backtracking(left, right + 1, max);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new Solution().generateParenthesis(n));
    }
}
