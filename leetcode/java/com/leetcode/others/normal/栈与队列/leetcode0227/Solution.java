package com.leetcode.others.normal.栈与队列.leetcode0227;

/*
力扣-227-基本计算器 II
normal-栈-模拟
 */

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int calculate(String s) {
        s = s.trim();
        char op = '+';
        Deque<Integer> stack = new LinkedList<>();
        int res = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                op = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "1 + 2 * 3";
        System.out.println(new Solution().calculate(s));
    }
}
