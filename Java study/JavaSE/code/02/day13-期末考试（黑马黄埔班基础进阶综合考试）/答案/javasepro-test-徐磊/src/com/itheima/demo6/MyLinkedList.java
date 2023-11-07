package com.itheima.demo6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLinkedList<E extends Comparable> {
    // 封装一个链表
    Node<E> head = null;

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

    public Node<E> add(E e) {
        if (head == null) {
            head = new Node(e, null);
        } else {
            // 往后面插入结点。（尾插法）
            Node<E> temp = head;
            // 让temp走到尾部结点
            while (temp.next != null) {
                temp = temp.next;
            }
            // 把当前结点创建出来，加入到尾部结点
            temp.next = new Node(e, null);
        }
        return head;
    }

    public Node<E> sorted() {
        if (head == null) {
            return head;
        }

        List<E> number = new ArrayList<>();
        Node<E> temp = head;
        while (temp != null) {
            number.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(number);

        Node<E> temp2 = head;
        for (E e : number) {
            temp2.data = e;
            temp2 = temp2.next;
        }
        return head;
    }

    public void forEach(Node<E> head) {
        if (head == null) {
            System.out.println(head);
            return;
        }
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node<E> mergeSort(Node<E> head2) {
        // head =  1 2 3
        // head2 = 1 3 4
        if (head == null && head2 == null) {
            return null;
        }

        if (head == null && head2 != null) {
            return head2;
        }

        if (head != null && head2 == null) {
            return head;
        }

     /*   if(head != null && head2 != null){
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            // 尾部了。
            temp.next = head2;
            sorted();
        }*/

        if (head != null && head2 != null) {
            // head =  1     2  2
            //                      temp1
            // head2 = 1      3  4 5 6 6 8 9
            //                temp2
            // newHead 1  1  2  2
            Node<E> newHead = new Node<>(null, null); // 新链表
            Node<E> newTemp = newHead;
            Node<E> temp1 = head;
            Node<E> temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.data.compareTo(temp2.data) == -1) {
                    newHead.next = temp1;
                    temp1 = temp1.next;
                } else {
                    newHead.next = temp2;
                    temp2 = temp2.next;
                }
                newHead = newHead.next;
            }

            if (temp1 == null) {
                newHead.next = temp2;
            }

            if (temp2 == null) {
                newHead.next = temp1;
            }
            head = newTemp.next;
        }
        return head;
    }
}