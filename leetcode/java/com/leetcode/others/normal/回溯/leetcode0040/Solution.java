package com.leetcode.others.normal.回溯.leetcode0040;

/*
力扣-40-组合总和 II
normal-回溯
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtracking(candidates, target, res, path, used, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, boolean[] used, int startIndex, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            if (candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, res, path, used, i + 1, sum);
            used[i] = false;
            sum -= candidates[i];
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
        System.out.println(new Solution().combinationSum2(candidates, target));
    }
}
