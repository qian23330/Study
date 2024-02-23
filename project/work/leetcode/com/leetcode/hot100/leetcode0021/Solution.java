package com.leetcode.hot100.leetcode0021;

/*
力扣-21-合并两个有序链表
hot100-链表
 */

import com.leetcode.commons.LinkedlistSolution;
import com.leetcode.commons.ListNode;

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
        ListNode head1 = LinkedlistSolution.createLinkedListFromUserInput();
        ListNode head2 = LinkedlistSolution.createLinkedListFromUserInput();
        LinkedlistSolution.printLinkedList(new Solution().mergeTwoLists(head1, head2));
    }
}
