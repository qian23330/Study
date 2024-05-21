package com.leetcode.others.sort.leetcode0215;

/*
力扣-215-数组中的第K个最大元素
hot100-快速选择
 */

import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> big = new ArrayList<>();

        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size()));
        for (Integer num : nums) {
            if (num > pivot) big.add(num);
            else if (num < pivot) small.add(num);
            else equal.add(num);
        }
        if (k <= big.size()) return quickSelect(big, k);
        if (k > big.size() + equal.size()) return quickSelect(small, k - (big.size() + equal.size()));
        return pivot;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = scanner.nextInt();
        System.out.println(new Solution().findKthLargest(nums, k));
    }
}
