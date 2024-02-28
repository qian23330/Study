package com.leetcode.hot100.leetcode0046;

/*
力扣-46-全排列
hot100-回溯
 */

import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, path);
        return result;
    }

    private void backtracking(int[] nums, Deque<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.push(num);
            backtracking(nums, path);
            path.pop();
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
