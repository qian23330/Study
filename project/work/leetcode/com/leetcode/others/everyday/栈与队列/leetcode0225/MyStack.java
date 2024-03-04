package com.leetcode.others.everyday.栈与队列.leetcode0225;

/*
力扣-225-用队列实现栈
每日一题-24.03.03-队列-模拟
 */

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> A;
    private Queue<Integer> B;

    public MyStack() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x) {
        B.offer(x);
        while (!A.isEmpty()) {
            B.offer(A.poll());
        }
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    public int pop() {
        if (!A.isEmpty()) {
            return A.poll();
        } else {
            return -1;
        }
    }

    public int top() {
        if (!A.isEmpty()) {
            return A.peek();
        } else {
            return -1;
        }
    }

    public boolean empty() {
        return A.isEmpty();
    }
}
