package com.leetcode.hot100.二分查找.leetcode0034;

/*
力扣-34-在排序数组中查找元素的第一个和最后一个位置
hot100-二分查找
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) return new int[]{-1, -1};
        int left = index, right = index;
        while (left - 1 >= 0 && nums[left - 1] == target) left--;
        while (right + 1 < nums.length && nums[right + 1] == target) right++;
        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));
    }
}
