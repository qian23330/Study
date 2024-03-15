package com.leetcode.hot100.栈与队列.leetcode0239;

/*
力扣-239-滑动窗口最大值
hot100-单调队列
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {  // 窗口个数为 n - k + 1, 左边界范围为 [1 - k, n - k], 右边界范围为 [0, n - 1]
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }
            // 保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if (i >= 0) {
                res[i] = deque.peekFirst();
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
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, k)));
    }
}
