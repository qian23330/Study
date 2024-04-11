package com.leetcode.others.normal.链表.leetcode0092;

/*
力扣-92-反转链表 II
normal-链表区间反转
 */

import com.leetcode.utils.LinkedlistSolution;
import com.leetcode.utils.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head), pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        reverseList(leftNode);
        pre.next = rightNode;
        leftNode.next = cur;
        return dummy.next;
    }

    private void reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        int left = scanner.nextInt();
        scanner.nextLine();
        int right = scanner.nextInt();
        LinkedlistSolution.printLinkedList(new Solution().reverseBetween(head, left, right));
    }
}
