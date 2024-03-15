package com.leetcode.hot100.二分查找.leetcode0004;

/*
力扣-4-寻找两个正序数组的中位数
hot100-数组-二分查找
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int k = (n1 + n2 + 1) / 2;
        int left = 0;
        int right = n1;
        while (left < right) {
            int m1 = left + (right - left) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]){
                left = m1 + 1;
            } else {
                right = m1;
            }
        }

        int m1 = left;
        int m2 = k - m1;

        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if ((n1 + n2) % 2 == 1) {
            return c1;
        }

        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1], m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) / 2.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        int[] nums1 = Arrays.stream(input1)
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] nums2 = Arrays.stream(input2)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}

