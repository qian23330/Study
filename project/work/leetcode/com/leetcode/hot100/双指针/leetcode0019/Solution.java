package com.leetcode.hot100.双指针.leetcode0019;

/*
力扣-19-删除链表的倒数第 N 个结点
hot100-快慢指针
 */

import com.leetcode.commons.LinkedlistSolution;
import com.leetcode.commons.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1), slow = dummy, fast = dummy;
        dummy.next = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一组数，以空格分隔：");
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        System.out.println("请输入n：");
        int n = scanner.nextInt();
        ListNode node = new Solution().removeNthFromEnd(head, n);
        LinkedlistSolution.printLinkedList(node);
    }
}
