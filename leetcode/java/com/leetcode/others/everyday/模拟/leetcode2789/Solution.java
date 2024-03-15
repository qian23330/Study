package com.leetcode.others.everyday.模拟.leetcode2789;

/*
力扣-2789-合并后数组中的最大元素
每日一题-24.03.14-数组-模拟
*/

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public long maxArrayValue(int[] nums) {
        long sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0 ; i--) {
            sum = nums[i] <= sum ? sum + nums[i] : nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().maxArrayValue(nums));
    }
}
