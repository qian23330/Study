package com.leetcode.commons;

import java.util.Scanner;

public class LinkedlistSolution {
    static ListNode createLinkedListFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以','分隔：");
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

    static void printLinkedList(ListNode head) {
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
