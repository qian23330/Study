package com.leetcode.hot100.哈希.leetcode0041;

/*
力扣-41-缺失的第一个正数
hot100-数组-哈希
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num > 0) {
                map.put(num, 1);
            }
        }
        int min = 1;
        while (map.containsKey(min)) {
            min++;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}
