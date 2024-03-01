package com.leetcode.others.normal.栈与队列.leetcode0232;

/*
力扣-232-用栈实现队列
normal-栈-模拟
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
        int peek = peek();
        B.pop();
        return peek;
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
