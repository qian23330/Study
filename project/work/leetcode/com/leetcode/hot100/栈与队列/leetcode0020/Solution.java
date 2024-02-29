package com.leetcode.hot100.栈与队列.leetcode0020;

import java.util.*;

/*
力扣-20-有效的括号
hot100-栈
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char item : s.toCharArray()) {
            if (item == '(') {
                stack.push(')');
            } else if (item == '[') {
                stack.push(']');
            } else if (item == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != item) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().isValid(s));
    }
}
