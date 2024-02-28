package com.leetcode.hot100.leetcode0215;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
力扣-215-数组中的第K个最大元素
hot100-优先队列/堆排序
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for(int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println("请输入一组数字，以空格分隔：");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("请输入k值：");
        int k = scanner.nextInt();
        System.out.println(new Solution().findKthLargest(nums, k));
    }
}
