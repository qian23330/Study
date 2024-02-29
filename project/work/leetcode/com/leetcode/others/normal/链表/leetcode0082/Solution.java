package com.leetcode.others.normal.链表.leetcode0082;

/*
力扣-82-删除排序链表中的重复元素 II
normal-链表
 */

import com.leetcode.commons.LinkedlistSolution;
import com.leetcode.commons.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        dummy.next = head;
        while (cur.next != null && cur.next.next != null) {
            int value = cur.next.val;
            if (cur.next.next.val == value) {
                while (cur.next != null && cur.next.val == value) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        LinkedlistSolution.printLinkedList(new Solution().deleteDuplicates(head));
    }
}
