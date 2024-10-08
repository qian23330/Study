package com.leetcode.others.normal.双指针.leetcode0088;

/*
力扣-88-合并两个有序数组
normal-双指针
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
              cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        System.arraycopy(sorted, 0, nums1, 0, nums1.length);
    }

    public static void main(String[] args) {
        System.out.println("请输入nums1数组，以逗号分隔：");
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(",");
        int[] nums1 = Arrays.stream(input1)
                            .mapToInt(Integer::parseInt)
                            .toArray();
        System.out.println("请输入nums2数组，以逗号分隔：");
        String[] input2 = scanner.nextLine().split(",");
        int[] nums2 = Arrays.stream(input2)
                            .mapToInt(Integer::parseInt)
                            .toArray();
        System.out.println("请输入m：");
        int m = scanner.nextInt();
        System.out.println("请输入n：");
        int n = scanner.nextInt();
        new Solution().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
