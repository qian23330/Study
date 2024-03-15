package com.leetcode.others.normal.二分查找.leetcode0704;

/*
力扣-704-二分查找
normal
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("请输入target：");
        int target = scanner.nextInt();
        System.out.println(new Solution().search(nums, target));
    }
}
