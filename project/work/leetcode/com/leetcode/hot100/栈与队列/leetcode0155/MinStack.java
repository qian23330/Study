package com.leetcode.hot100.栈与队列.leetcode0155;

/*
力扣-155-最小栈
hot100-栈-模拟
 */

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min_stack;

    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min_stack.isEmpty() || val <= min_stack.peek()) {
            min_stack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(min_stack.peek())) {
            min_stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) return stack.peek();
        return -1;
    }

    public int getMin() {
        if (!min_stack.isEmpty()) return min_stack.peek();
        return -1;
    }
}
