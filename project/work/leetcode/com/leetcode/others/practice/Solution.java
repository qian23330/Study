package com.leetcode.others.practice;

/*
力扣
practice-练习
 */

import java.util.Deque;
import java.util.LinkedList;

class MyQueue {
    private Deque<Integer> A;
    private Deque<Integer> B;

    public MyQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x) {
        A.push(x);
    }

    public int pop() {
        int x = peek();
        B.pop();
        return x;
    }

    public int peek() {
        if (!B.isEmpty()) return B.peek();
        if (A.isEmpty()) return -1;
        while (!A.isEmpty()) {
            B.push(A.pop());
        }
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}

