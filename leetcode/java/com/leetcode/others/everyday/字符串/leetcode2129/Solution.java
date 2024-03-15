package com.leetcode.others.everyday.字符串.leetcode2129;

/*
力扣-2129-将标题首字母大写
每日一题-24.03.11-字符串
*/

import java.util.Scanner;

class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1 || words[i].length() == 2) {
                words[i] = words[i].toLowerCase();
            } else {
                String c = words[i].substring(0, 1).toUpperCase();
                String s = words[i].substring(1).toLowerCase();
                words[i] = c + s;
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println(new Solution().capitalizeTitle(title));
    }
}
