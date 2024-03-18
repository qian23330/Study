package com.leetcode.hot100.二分查找.leetcode0153;

/*
力扣-153-寻找旋转排序数组中的最小值
hot100-数组-二分查找
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().findMin(nums));
    }
}
