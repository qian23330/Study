package com.leetcode.others.normal.链表.leetcode0876;

/*
力扣-876-链表的中间结点
normal-链表-快慢指针
 */

import com.leetcode.utils.LinkedlistSolution;
import com.leetcode.utils.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个链表，以空格分隔：");
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        System.out.println(new Solution().middleNode(head).val);
    }
}
