package com.leetcode.others.normal.leetcode0092;

/*
力扣-92-反转链表 II
normal-链表
 */

import com.leetcode.commons.LinkedlistSolution;
import com.leetcode.commons.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head), p = dummy;
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
        }
        ListNode cur = p.next;
        ListNode pre = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        p.next.next = cur;
        p.next = pre;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] values = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(values);
        System.out.println("请输入left：");
        int left = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入right：");
        int right = scanner.nextInt();
        LinkedlistSolution.printLinkedList(new Solution().reverseBetween(head, left, right));
    }
}
