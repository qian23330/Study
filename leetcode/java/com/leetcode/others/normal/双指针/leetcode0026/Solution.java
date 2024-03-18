package com.leetcode.others.normal.双指针.leetcode0026;

/*
力扣-26-删除有序数组中的重复项
normal-双指针
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 1, fast = slow;
        int len = nums.length;
        while (fast < len) {
            if (nums[fast - 1] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().removeDuplicates(nums));
    }
}
