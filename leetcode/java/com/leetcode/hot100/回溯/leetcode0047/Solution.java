package com.leetcode.hot100.回溯.leetcode0047;

/*
力扣-47-全排列 II
hot100-回溯
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return res;
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().permuteUnique(nums));
    }

}
