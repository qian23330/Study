package com.leetcode.hot100.栈与队列.leetcode0084;

/*
力扣-84-柱状图中最大的矩形
hot100-单调栈
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        int[] left = new int[n], right = new int[n], res = new int[n];
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> rightStack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[i]) {
                leftStack.pop();
            }
            left[i] = !leftStack.isEmpty() ? leftStack.peek() : -1;
            leftStack.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[i]) {
                rightStack.pop();
            }
            right[i] = !rightStack.isEmpty() ? rightStack.peek() : n;
            rightStack.push(i);
        }

        for (int i = 0; i < n; i++) {
            res[i] = (right[i] - left[i] - 1) * heights[i];
        }
        return Arrays.stream(res).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] heights = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}
