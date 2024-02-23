package com.leetcode.hot100.leetcode0025;

/*
力扣-25-K个一组翻转链表
hot100-链表
 */

import com.leetcode.commons.LinkedlistSolution;
import com.leetcode.commons.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode head = LinkedlistSolution.createLinkedListFromUserInput();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入k值：");
        int k = scanner.nextInt();
        ListNode res = new Solution().reverseKGroup(head, k);
        LinkedlistSolution.printLinkedList(res);
    }
}
