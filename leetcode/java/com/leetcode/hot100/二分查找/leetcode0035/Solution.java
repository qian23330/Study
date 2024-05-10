package com.leetcode.hot100.二分查找.leetcode0035;

/*
力扣-35-搜索插入位置
hot100-二分查找
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;
            else if (nums[mid] == target) return mid;
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = scanner.nextInt();
        System.out.println(new Solution().searchInsert(nums, target));
    }
}
