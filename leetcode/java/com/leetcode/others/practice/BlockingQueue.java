package com.leetcode.others.practice;

public class BlockingQueue {
    private int[] items;
    volatile private int head = 0;
    volatile private int tail = 0;
    volatile private int size = 0;
    public BlockingQueue(){
        this.items = new int[100];
    }

    /**
     * 手撕阻塞队列——入队
     * @param elem
     * @throws InterruptedException
     */
    public void put(int elem) throws InterruptedException {
        synchronized (this){
            while(size >= items.length){
                // 队列满了，采取等待策略
                this.wait();
            }
            // 队列没满:添加元素
            if(tail >= items.length ){
                tail = 0;
            }
            items[tail] = elem;
            tail++;
            size++;
            // 成功入队，唤醒因为队列空间被阻塞进入的状态
            this.notify();
        }
    }

    /**
     * 出队列
     * @return
     * @throws InterruptedException
     */
    public int take() throws InterruptedException {
        synchronized (this){
            while (size == 0){
                //队列空
                //return -1;
                this.wait();
            }
            if (head >= items.length){
                head = 0;
            }
            int elem = items[head];
            head++;
            size--;
            this.notify();//使用这个notify唤醒队列满的阻塞状态
            return elem;
        }
    }

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();

        //生产者线程
        Thread product = new Thread(()->{
            int count = 0;
            while (true){
                try {
                    queue.put(count);
                    System.out.println("生产元素:>"+count);
                    count++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //消费者线程
        Thread consummer = new Thread(()->{
            while (true){
                try {
                    int elem = queue.take();
                    System.out.println("消费元素:>"+elem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        product.start();
        consummer.start();
    }
}
