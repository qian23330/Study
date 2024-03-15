package com.leetcode.utils;

public class LinkedlistSolution {
    public static ListNode createLinkedList(String[] args) {

        if (args.length == 0) return null;

        ListNode head = new ListNode(Integer.parseInt(args[0]));
        ListNode current = head;

        for (int i = 1; i < args.length; i++) {
            current.next = new ListNode(Integer.parseInt(args[i]));
            current = current.next;
        }

        return head;
    }

    public static ListNode buildCircularLinkedList(String[] args, int pos) {

        if (args.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode cycle = null;

        for (int i = 0; i < args.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(args[i]));
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
