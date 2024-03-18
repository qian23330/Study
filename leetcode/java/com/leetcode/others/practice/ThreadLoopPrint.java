package com.leetcode.others.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 3 个线程交替打印 ABC
 */
public class ThreadLoopPrint {
    // 共享计数器
    private static int sharedCounter = 0;
    public static void main(String[] args) {
        // 打印的内容
        String printString = "ABC";
        // 定义循环栅栏
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
        });
        // 执行任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < printString.length(); i++) {
                    synchronized (this) {
                        sharedCounter = sharedCounter > 2 ? 0 : sharedCounter; // 循环打印
                        System.out.println(printString.toCharArray()[sharedCounter++]);
                    }
                    try {
                        // 等待 3 个线程都打印一遍之后，继续走下一轮的打印
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        // 开启多个线程
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}

