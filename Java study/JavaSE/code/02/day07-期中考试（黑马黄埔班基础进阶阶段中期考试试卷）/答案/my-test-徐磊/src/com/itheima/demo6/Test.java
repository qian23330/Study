package com.itheima.demo6;

public class Test {
    public static void main(String[] args) {
        // 目标：链表的题目
        MyLinkedList<String> list = new MyLinkedList<>();
        MyLinkedList.Node<String> head = list.add();
        MyLinkedList.Node<String> head2 = list.reverse(head, 1, 5);
        list.forEach(head2);
    }
}
