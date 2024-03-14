package com.leetcode.others.everyday.字符串.leetcode2864;

/*
力扣-2864-最大二进制奇数
每日一题-24.03.13-字符串
*/

import java.util.Scanner;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt = (int) s.chars().filter(c -> c == '1').count();
        StringBuilder res = new StringBuilder();
        return res.append(('1' + "").repeat(cnt - 1))
                .append(('0' + "").repeat(s.length() - cnt))
                .append('1' + "").toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().maximumOddBinaryNumber(s));
    }
}
