package com.leetcode.hot100.leetcode0206;

/*
力扣-206-反转链表
hot100-链表
 */

import com.leetcode.commons.LinkedlistSolution;
import com.leetcode.commons.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = LinkedlistSolution.createLinkedListFromUserInput();
        LinkedlistSolution.printLinkedList(new Solution().reverseList(head));
    }
}
