package com.leetcode.hot100.回溯.leetcode0046;

/*
力扣-46-全排列
hot100-回溯
 */

import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        used = new boolean[nums.length];
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入一组数字，以空格分隔：");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().permute(nums));
    }
}
