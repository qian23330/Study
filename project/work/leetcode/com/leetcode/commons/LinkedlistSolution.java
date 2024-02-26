package com.leetcode.commons;

import java.util.Scanner;

public class LinkedlistSolution {
    public static ListNode createLinkedList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以逗号分隔：");
        String[] values = scanner.nextLine().split(",");

        if (values.length == 0) return null;

        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i]));
            current = current.next;
        }

        return head;
    }

    public static ListNode buildCircularLinkedList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以逗号分隔：");
        String[] values = scanner.nextLine().split(",");
        System.out.println("请输入环形链表连接点pos：");
        int pos = scanner.nextInt();

        if (values.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode cycle = null;

        for (int i = 0; i < values.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(values[i]));
            cur.next = node;
            cur = node;

            if (i == pos) {
                cycle = node;
            }
        }

        // Make it a circular list
        cur.next = cycle;

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;

        if (head == null) {
            System.out.println("[]");
            return;
        }

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("None");
    }
}
