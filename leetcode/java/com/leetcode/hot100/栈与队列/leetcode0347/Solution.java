package com.leetcode.hot100.栈与队列.leetcode0347;

/*
力扣-347-前 K 个高频元素
hot100-堆
 */

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (Integer i : map.keySet()) {
            heap.offer(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = heap.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = scanner.nextInt();
        System.out.println(Arrays.toString(new Solution().topKFrequent(nums, k)));
    }
}
