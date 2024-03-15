package com.leetcode.others.normal.回溯.leetcode0077;

/*
力扣-77-组合
normal-回溯
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, res, path, 1);
        return res;
    }

    private void backtracking(int n, int k, List<List<Integer>> res, List<Integer> path, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] pair = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = pair[0];
        int k = pair[1];
        System.out.println(new Solution().combine(n, k));
    }
}
