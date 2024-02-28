package com.leetcode.hot100.leetcode0001;

/*
力扣-1-两数之和
hot100-哈希表
 */

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (seen.containsKey(res)) {
                return new int[]{seen.get(res), i};
            }
            seen.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println("请输入一组数据，以空格分隔：");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("请输入target：");
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
    }
}
