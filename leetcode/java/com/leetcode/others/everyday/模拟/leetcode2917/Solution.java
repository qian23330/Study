package com.leetcode.others.everyday.模拟.leetcode2917;

/*
力扣-2917-找出数组中的 K-or 值
每日一题-24.03.06-模拟-位运算
*/

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int findKOr(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < 31; i++) {  // nums元素不超过2^31，i 范围[0, 31)
            int cnt = 0;
            for (int num : nums) {
                if (((num >> i) & 1) != 0) {  // (num >> i) & 1 为 num的第i位
                    cnt++;
                }
            }
            if (cnt >= k) {
                res |= 1 << i;  // 在res的第i位上赋值为1
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = scanner.nextInt();
        System.out.println(new Solution().findKOr(nums, k));
    }
}
