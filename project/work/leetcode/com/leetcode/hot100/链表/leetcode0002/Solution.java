package com.leetcode.hot100.链表.leetcode0002;

/*
力扣-2-两数相加
hot100-链表
 */

import com.leetcode.util.LinkedlistSolution;
import com.leetcode.util.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        ListNode l1 = LinkedlistSolution.createLinkedList(input1);
        ListNode l2 = LinkedlistSolution.createLinkedList(input2);
        LinkedlistSolution.printLinkedList(new Solution().addTwoNumbers(l1, l2));
    }
}
