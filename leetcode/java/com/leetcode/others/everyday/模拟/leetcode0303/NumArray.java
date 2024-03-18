package com.leetcode.others.everyday.模拟.leetcode0303;

/*
力扣-303-区域和检索 - 数组不可变
每日一题-24.03.18-前缀和
*/

import java.util.Arrays;
import java.util.Scanner;

class NumArray {
    private final int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        NumArray array = new NumArray(nums);
        int sum = array.sumRange(0, 2);
        System.out.println(sum);
    }
}
