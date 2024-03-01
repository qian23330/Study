package com.leetcode.hot100.链表.leetcode0021;

/*
力扣-21-合并两个有序链表
hot100-链表
 */

import com.leetcode.util.LinkedlistSolution;
import com.leetcode.util.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] values1 = scanner.nextLine().split(" ");
        String[] values2 = scanner.nextLine().split(" ");
        ListNode head1 = LinkedlistSolution.createLinkedList(values1);
        ListNode head2 = LinkedlistSolution.createLinkedList(values2);
        LinkedlistSolution.printLinkedList(new Solution().mergeTwoLists(head1, head2));
    }
}
