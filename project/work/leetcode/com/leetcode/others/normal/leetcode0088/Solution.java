package com.leetcode.others.normal.leetcode0088;

/*
力扣-88-合并两个有序数组
normal-双指针
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int sorted[] = new int[m + n];
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
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入nums1数组，以逗号分隔：");
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(",");
        int nums1[] = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            nums1[i] = Integer.parseInt(input1[i]);
        }
        System.out.println("请输入nums2数组，以逗号分隔：");
        String[] input2 = scanner.nextLine().split(",");
        int nums2[] = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            nums2[i] = Integer.parseInt(input2[i]);
        }
        System.out.println("请输入m：");
        int m = scanner.nextInt();
        System.out.println("请输入n：");
        int n = scanner.nextInt();
        new Solution().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
