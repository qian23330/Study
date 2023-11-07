package com.itheima.demo6;

public class Test {
    public static void main(String[] args) {
        // 第一个链表：
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.add(2);
        list1.add(4);
        list1.add(1);
        // 第一个链表的头结点：head1
        MyLinkedList.Node<Integer> head1 = list1.head;

        // 第二个链表：
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.add(4);
        list2.add(1);
        list2.add(3);
        list2.add(2);
        list2.add(8);
        list2.add(9);
        // 第二个链表的头结点：head1
        MyLinkedList.Node<Integer> head2 = list2.head;

        // 功能1：在MyLinkedList类中，开发一个sort方法，对两个链表分别排序，并分别遍历输出
        MyLinkedList.Node<Integer> first1 = list1.sorted();
        MyLinkedList.Node<Integer> first2 = list2.sorted();
        list1.forEach(first1);
        list2.forEach(first2);

        // 功能2：在MyLinkedList类中，开发一个mergeSort方法，支持将这两个升序排序的链表，合并成一个新链表，要求新链表中的节点仍然是递增排序的。
        // ，然后对新链表遍历输出
        MyLinkedList.Node<Integer> allFirstHead = list1.mergeSort(first2);
        list1.forEach(allFirstHead);
    }
}
