package com.leetcode.hot100.栈与队列.leetcode0394;

/*
力扣-394-字符串解码
hot100-栈
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public String decodeString(String s) {
        int num = 0;  // 数字
        StringBuilder res = new StringBuilder();
        Deque<Integer> stack_num = new LinkedList<>();
        Deque<String> stack_res = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack_num.push(num);
                stack_res.push(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_num = stack_num.pop();
                tmp.append(res.toString().repeat(cur_num));
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + Integer.parseInt(c + "");  // 连续数字
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().decodeString(s));
    }
}
