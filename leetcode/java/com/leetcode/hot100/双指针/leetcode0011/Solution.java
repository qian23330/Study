package com.leetcode.hot100.双指针.leetcode0011;

/*
力扣-11-盛最多水的容器
hot100-双指针
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int water = 0;
        while (left < right) {
            water = height[left] < height[right] ?
                    Math.max(water, (right - left) * height[left++]) :
                    Math.max(water, (right - left) * height[right--]);
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] height = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().maxArea(height));
    }
}
