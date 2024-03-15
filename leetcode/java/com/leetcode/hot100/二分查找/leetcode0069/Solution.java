package com.leetcode.hot100.二分查找.leetcode0069;

/*
力扣-69-x 的平方根
hot100-二分查找
 */

import java.util.Scanner;

class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right){
            int mid = left + (right - left) / 2;
            long midSqr = (long) mid * mid;
            if (midSqr == x) {
                return mid;
            } else if (midSqr < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(new Solution().mySqrt(x));
    }
}
