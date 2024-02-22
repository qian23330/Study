package com.leetcode.hot100.leetcode0053;

import java.util.Scanner;

/*
力扣-53-最大子序和
hot100-贪心
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            if (count > result) {
                result = count;
            }
            if (count <= 0) {
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        int[] nums = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            nums[i] = Integer.parseInt(inputArray[i]);
        }
        System.out.println(new Solution().maxSubArray(nums));
    }
}

