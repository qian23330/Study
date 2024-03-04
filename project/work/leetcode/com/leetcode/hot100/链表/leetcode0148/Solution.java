package com.leetcode.hot100.链表.leetcode0148;

/*
力扣-148-排序链表
hot100-链表-归并排序
 */

import com.leetcode.util.LinkedlistSolution;
import com.leetcode.util.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next, slow = head;  // 找链表中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        LinkedlistSolution.printLinkedList(new Solution().sortList(head));
    }
}
