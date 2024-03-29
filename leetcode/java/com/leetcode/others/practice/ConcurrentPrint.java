package com.leetcode.others.practice;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ConcurrentPrint {  // 多线程交替打印abcd，要求线程1打印a，线程2打印a，线程1打印b，线程2打印b。。。。。。
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        String str = "abcd";
        int len = str.length();
        Semaphore first = new Semaphore(1);
        Semaphore second = new Semaphore(0);

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(() -> {
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                try {
                    first.acquire(1);
                } catch (InterruptedException e) {
                }
                System.out.println("线程1：" + c);
                second.release(1);
            }
        });
        threadPool.execute(() -> {
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                try {
                    second.acquire(1);
                } catch (InterruptedException e) {
                }
                System.out.println("线程2：" + c);
                first.release(1);
            }
        });
    }
}
