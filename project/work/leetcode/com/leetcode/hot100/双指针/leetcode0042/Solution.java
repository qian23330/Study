package com.leetcode.hot100.双指针.leetcode0042;

/*
力扣-42-接雨水
hot100-双指针
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int rain = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            rain += height[left] < height[right] ?
                    leftMax - height[left++] :
                    rightMax - height[right--];
        }
        return rain;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] height = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().trap(height));
    }
}
