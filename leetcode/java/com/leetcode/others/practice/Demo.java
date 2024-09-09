package com.leetcode.others.practice;

import java.util.Deque;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        Deque<Character> stack = new LinkedList<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        for (Character c : stack) {
            System.out.println(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('c');
    }
}
