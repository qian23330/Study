package com.leetcode.others.normal.leetcode0093;

/*
力扣-93-复原IP地址
normal-回溯
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex == s.length() && path.size() == 4) {
            res.add(String.join(".", path));
            return;
        }
        if (path.size() > 4) return;  // 剪枝

        for (int i = startIndex; i < Math.min(s.length(), startIndex + 3); i++) {  // 控制ip段长度（0~255）
            if (isValid(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false;
        int num = Integer.parseInt(s.substring(start, end + 1));
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String input = scanner.nextLine();
        System.out.println(new Solution().restoreIpAddresses(input));
    }
}
