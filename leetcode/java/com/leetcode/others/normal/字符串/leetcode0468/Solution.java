package com.leetcode.others.normal.字符串.leetcode0468;

/*
力扣-468-验证IP地址
normal-字符串
 */

import java.util.Scanner;

class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf('.') >= 0) {
            return isIpV4(queryIP) ? "IPv4" : "Neither";
        } else {
            return isIpV6(queryIP) ? "IPv6" : "Neither";
        }
    }

    private boolean isIpV4(String queryIP) {
        String[] split = queryIP.split("\\.", -1);
        if (split.length != 4) return false;
        for (String s : split) {
            if (s.length() > 3 || s.isEmpty()) return false;
            if (s.charAt(0) == '0' && s.length() != 1) return false;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!Character.isDigit(c)) return false;
                res = res * 10 + (c - '0');
            }
            if (res > 255) return false;
        }
        return true;
    }

    private boolean isIpV6(String queryIP) {
        String[] split = queryIP.split(":", -1);
        if (split.length != 8) return false;
        for (String s : split) {
            if (s.length() > 4 || s.isEmpty()) return false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!Character.isDigit(c) && !(Character.toLowerCase(c) >= 'a') || !(Character.toLowerCase(c) <= 'f')) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String queryIP = scanner.nextLine();
        System.out.println(new Solution().validIPAddress(queryIP));
    }
}
