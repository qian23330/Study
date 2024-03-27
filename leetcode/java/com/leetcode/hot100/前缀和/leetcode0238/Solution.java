package com.leetcode.hot100.前缀和.leetcode0238;

/*
力扣-238-除自身以外数组的乘积
hot100-前/后缀积
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        int[] res = new int[len];
        L[0] = 1;
        R[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));
    }
}
