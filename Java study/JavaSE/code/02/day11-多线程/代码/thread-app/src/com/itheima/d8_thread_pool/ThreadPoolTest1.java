package com.itheima.d8_thread_pool;

import java.util.concurrent.*;
/**
 * 目标：掌握线程池的创建。
 */
public class ThreadPoolTest1 {
    public static void main(String[] args) {
        // 1、通过ThreadPoolExecutor创建一个线程池对象。
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 8,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        Runnable target = new MyRunnable();
        pool.execute(target); // 线程池会自动创建一个新线程，自动处理这个任务，自动执行的！
        pool.execute(target); // 线程池会自动创建一个新线程，自动处理这个任务，自动执行的！
        pool.execute(target); // 线程池会自动创建一个新线程，自动处理这个任务，自动执行的！
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        // 到了临时线程的创建时机了
        pool.execute(target);
        pool.execute(target);
        // 到了新任务的拒绝时机了！
        pool.execute(target);

        // pool.shutdown(); // 等着线程池的任务全部执行完毕后，再关闭线程池
        // pool.shutdownNow(); // 立即关闭线程池！不管任务是否执行完毕！
    }
}
