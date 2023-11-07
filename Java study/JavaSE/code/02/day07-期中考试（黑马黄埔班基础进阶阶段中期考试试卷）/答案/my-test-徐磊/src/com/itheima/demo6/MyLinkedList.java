package com.itheima.demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyLinkedList<E> {
    private int size;
    /**
     * 定义了一个私有的内部类，作为链表的结点。
     */
    public static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node<E> add(){
        Node<E> head = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请你输入结点的值：");
            String data = sc.next();
            if(data.equals("exit")) break;
            if(head == null) {
                head = new Node(data, null);
                size++;
            }else {
                // 往后面插入结点。（尾插法）
                Node<E> temp = head;
                // 让temp走到尾部结点
                while (temp.next != null) {
                    temp = temp.next;
                }
                // 把当前结点创建出来，加入到尾部结点
                temp.next = new Node(data, null);
                size++;
            }
        }
        return head;
    }

    // 1 2 3 4 5 6    left = 2   right = 5
    public Node<E> reverse(Node<E> head, int left, int right){
        if(head == null || left < 1 || left > size || right < 1 || right > size
             || left == right || left > right) {
            return head;
        }

        // 1、找出左节点的起始地址。
        // 2、从左边遍历到右节点，然后把数据先存入集合。
        Node<E> first = head;
        Node<E> mark = null;
        List<E> data = new ArrayList<>();
        int index = 0;
        while (head != null) {
            index++;
            if(index == left) {
                mark = head; // 左节点位置找到了。
            }

            if(index >= left && index <= right) {
                data.add(head.data);
            }

            if(index == right) break;

            head = head.next;
        }

        // 2、倒序遍历集合。
        for (int i = data.size() - 1; i >= 0; i--) {
            E e = data.get(i);
            mark.data = e;
            mark = mark.next;
        }

        return first;
    }

    public void forEach(Node<E> head){
        if(head == null){
            System.out.println(head);
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
