package com.leetcode.hot100.哈希.leetcode0169;

/*
力扣-169-多数元素
hot100-哈希
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int majorityElement(int[] nums) {
        int k = nums.length / 2;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) {
            if (!seen.containsKey(num)) {
                seen.put(num, 1);
            } else {
                seen.put(num, seen.get(num) + 1);
            }
        }
        for (int num : nums) {
            if (seen.get(num) > k) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().majorityElement(nums));
    }
}
