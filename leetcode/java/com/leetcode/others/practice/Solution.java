package com.leetcode.others.practice;

/*
力扣
practice-练习
 */


import java.util.*;

class Solution {
    public void m(int[] nums) {
        if (nums == null) return;
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < len; i++) {
            nums[i] = 0;
        }
    }
}

