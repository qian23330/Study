package com.leetcode.hot100.哈希.leetcode0128;

/*
力扣-128-最长连续序列
hot100-哈希表
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
