package com.leetcode.others.normal.链表.leetcode0083;

/*
力扣-83-删除排序链表中的重复元素
normal-链表
 */

import com.leetcode.utils.LinkedlistSolution;
import com.leetcode.utils.ListNode;
import java.util.Scanner;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        LinkedlistSolution.printLinkedList(new Solution().deleteDuplicates(head));
    }
}
