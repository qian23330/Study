package com.leetcode.hot100.双指针.leetcode0189;

/*
力扣-189-轮转数组
hot100-贪心
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseList(nums, 0, nums.length - 1);
        reverseList(nums, 0, k - 1);
        reverseList(nums, k, nums.length - 1);
    }

    private void reverseList(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = scanner.nextInt();
        new Solution().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
