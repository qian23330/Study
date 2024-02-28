package com.leetcode.others.practice;

/*
力扣
practice-练习
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] sortArray(int[] nums) {
        insertionSort(nums);
        return nums;
    }

    private void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i], j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] in = scanner.nextLine().split(",");
        int[] nums = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            nums[i] = Integer.parseInt(in[i]);
        }
        System.out.println(Arrays.toString(new Solution().sortArray(nums)));
    }
}
