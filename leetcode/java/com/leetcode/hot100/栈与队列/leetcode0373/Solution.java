package com.leetcode.hot100.栈与队列.leetcode0373;

/*
力扣-373-查找和最小的 K 对数字
堆
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (res.size() < k) {
            int[] nums = heap.poll();
            int i = nums[1];
            int j = nums[2];
            res.add(List.of(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                heap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return res;
    }
}
