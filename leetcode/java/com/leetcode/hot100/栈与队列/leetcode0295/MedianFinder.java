package com.leetcode.hot100.栈与队列.leetcode0295;

/*
力扣-295-数据流的中位数
hot100-堆
 */

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>();  // 保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x));  // 保存较小的一半
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.offer(num);
            B.offer(A.poll());
        } else {
            B.offer(num);
            A.offer(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
