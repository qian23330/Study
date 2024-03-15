package com.leetcode.others.normal.贪心.leetcode0179;

/*
力扣-179-最大数
normal-贪心
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        if (strs[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().largestNumber(nums));
    }
}
