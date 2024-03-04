package com.leetcode.hot100.回溯.leetcode0078;

/*
力扣-78-子集
hot100-回溯
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0, res, path);
        return res;
    }

    private void backtracking(int[] nums, int startIndex, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path));
        if (startIndex > nums.length - 1) {
            return;
        }
        for (int i = startIndex; i <= nums.length - 1; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().subsets(nums));
    }

}
