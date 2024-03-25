package com.leetcode.others.everyday.字符串.leetcode2864;

/*
力扣-2864-最大二进制奇数
每日一题-24.03.13-字符串
*/

import java.util.Scanner;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt = (int) s.chars().filter(c -> c == '1').count();
        return ('1' + "").repeat(cnt - 1) +
                ('0' + "").repeat(s.length() - cnt) +
                '1';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().maximumOddBinaryNumber(s));
    }
}
