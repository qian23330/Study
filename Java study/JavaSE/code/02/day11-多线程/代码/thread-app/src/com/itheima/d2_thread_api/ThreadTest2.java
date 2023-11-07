package com.itheima.d2_thread_api;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 目标：掌握sleep方法,join方法的作用。
 */
public class ThreadTest2 {
    public static void main(String[] args) throws Exception {
        System.out.println(Runtime.getRuntime().availableProcessors());
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            // 休眠5s
            if(i == 3){
                // 会让当前执行的线程暂停5秒，再继续执行
                // 项目经理让我加上这行代码，如果用户交钱了，我就注释掉！
                 Thread.sleep(5000);
            }
        }

        // join方法作用：让当前调用这个方法的线程先执行完。
        Thread t1 = new MyThread("1号线程");
        t1.start();
        t1.join();

        Thread t2 = new MyThread("2号线程");
        t2.start();
        t2.join();

        Thread t3 = new MyThread("3号线程");
        t3.start();
        t3.join();
    }
}
