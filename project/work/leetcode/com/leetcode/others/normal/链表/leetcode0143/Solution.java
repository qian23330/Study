package com.leetcode.others.normal.链表.leetcode0143;

/*
力扣-143-重排链表
normal-链表-反转/合并/中点
 */

import com.leetcode.util.LinkedlistSolution;
import com.leetcode.util.ListNode;

import java.util.Scanner;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = midList(head);
        ListNode node = mid.next;
        mid.next = null;  // 断开
        ListNode right = reverseList(node);
        mergeList(head, right);
    }

    private ListNode midList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }

    private void mergeList(ListNode head1, ListNode head2) {
        ListNode p1;
        ListNode p2;
        while (head1 != null && head2 != null) {
            p1 = head1.next;
            p2 = head2.next;
            head1.next = head2;
            head1 = p1;
            head2.next = head1;
            head2 = p2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入链表，以空格分隔，每行一条");
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        new Solution().reorderList(head);
        LinkedlistSolution.printLinkedList(head);
    }
}
