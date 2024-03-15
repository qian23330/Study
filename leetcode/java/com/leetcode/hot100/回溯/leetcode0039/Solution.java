package com.leetcode.hot100.回溯.leetcode0039;

/*
力扣-39-组合总和
hot100-回溯
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, res, path, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int startIndex, int total) {
        if (total == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (total + candidates[i]> target) continue;
            total += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, res, path, i, total);
            total -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] candidates = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = scanner.nextInt();
        System.out.println(new Solution().combinationSum(candidates, target));
    }
}
