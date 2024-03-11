package com.leetcode.hot100.双指针.leetcode0283;

/*
力扣-283-移动零
hot100-双指针
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
