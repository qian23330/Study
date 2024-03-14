package com.leetcode.hot100.链表.leetcode0024;

/*
力扣-24-两两交换链表中的节点
hot100-链表
 */

import com.leetcode.util.LinkedlistSolution;
import com.leetcode.util.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        dummy.next = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode tmp1 = cur.next, tmp2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = tmp1;
            cur.next.next.next = tmp2;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        LinkedlistSolution.printLinkedList(new Solution().swapPairs(head));
    }
}
