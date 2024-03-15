package com.leetcode.others.everyday.模拟.leetcode299;

/*
力扣-299-猜数字游戏
每日一题-24.03.10-模拟-哈希数组
*/

import java.util.Scanner;

class Solution {
    public String getHint(String secret, String guess) {
        int x = 0, y = 0;  // 公牛和母牛个数
        int[] cntS = new int[10];
        int[] cntG = new int[10];  // 哈希数组
        for (int i = 0; i < secret.length(); i++) {
            int a = secret.charAt(i) - '0', b = guess.charAt(i) - '0';
            if (a == b) {
                x++;
            } else {
                cntS[a]++;
                cntG[b]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            y += Math.min(cntS[i], cntG[i]);
        }
        return String.format("%dA%dB", x, y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secret = scanner.nextLine();
        String guess = scanner.nextLine();
        System.out.println(new Solution().getHint(secret, guess));
    }
}
