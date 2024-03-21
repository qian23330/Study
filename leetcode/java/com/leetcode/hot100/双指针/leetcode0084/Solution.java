package com.leetcode.hot100.双指针.leetcode0084;

/*
力扣-84-柱状图中最大的矩形
hot100-双指针
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int k = n / 2;
        int i = k, j = i;
        int res = heights[k], height = res;
        for (int l = 0; l < n - 1; l++) {
            if (j == n - 1 || i > 0 && heights[i - 1] > heights[j + 1]) {
                height = Math.min(height, heights[--i]);
            } else {
                height = Math.min(height, heights[++j]);
            }
            res = Math.max(res, height * (j - i + 1));
        }
        return res;
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
