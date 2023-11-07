package com.itheima.d3_collection_list;

import java.util.LinkedList;

/**
 * 目标：掌握LinkedList集合的使用。
 */
public class ListTest3 {
    public static void main(String[] args) {
        // 1、创建一个队列。
        LinkedList<String> queue = new LinkedList<>();
        // 入队
        queue.addLast("第1号人");
        queue.addLast("第2号人");
        queue.addLast("第3号人");
        queue.addLast("第4号人");
        System.out.println(queue);
        // 出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);
        System.out.println("--------------------------------------------------");
        // 2、创建一个栈对象。
        LinkedList<String> stack = new LinkedList<>();
        // 压栈(push)
        stack.push("第1颗子弹");
        stack.push("第2颗子弹");
        stack.push("第3颗子弹");
        stack.push("第4颗子弹");
        System.out.println(stack);
        // 出栈(pop)
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
