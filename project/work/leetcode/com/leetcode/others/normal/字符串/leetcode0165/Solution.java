package com.leetcode.others.normal.字符串.leetcode0165;

/*
力扣-165-比较版本号
normal-字符串
 */

import java.util.Scanner;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x < y) {
                return -1;
            }
            if (x > y) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String version1 = scanner.nextLine();
        String version2 = scanner.nextLine();
        System.out.println(new Solution().compareVersion(version1, version2));
    }
}
