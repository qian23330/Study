package com.leetcode.others.practice;

/*
力扣
practice-练习
 */


import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = Arrays.copyOfRange(nums, left, right + 1);
        int leftStart = 0, leftEnd = mid - left;
        int rightStart = mid + 1 - left, rightEnd = right - left;
        int i = leftStart, j = rightStart;
        for (int k = left; k <= right ; k++) {
            if (i > leftEnd) {
                nums[k] = tmp[j++];
            } else if (j > rightEnd || tmp[i] < tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
            }
        }
    }
}

