package com.leetcode.hot100.链表.leetcode0206;

/*
力扣-206-反转链表
hot100-链表
 */

import com.leetcode.utils.LinkedlistSolution;
import com.leetcode.utils.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] values = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(values);
        LinkedlistSolution.printLinkedList(new Solution().reverseList(head));
    }
}
