package com.leetcode.others.normal.字符串.leetcode0008;

/*
力扣-8-字符串转换整数 (atoi)
normal-字符串
 */

import java.util.Scanner;

class Solution {
    public int myAtoi(String s) {
        char[] cs = s.trim().toCharArray();
        if (cs.length == 0) {
            return 0;
        }
        int res = 0, max = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (cs[0] == '-') {
            sign = -1;
        }
        else if (cs[0] != '+') {
            i = 0;
        }
        for (int j = i; j < cs.length; j++) {
            if (cs[j] < '0' || cs[j] > '9') {
                break;
            }
            if (res > max || res == max && cs[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (cs[j] - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(new Solution().myAtoi(input));
    }
}

