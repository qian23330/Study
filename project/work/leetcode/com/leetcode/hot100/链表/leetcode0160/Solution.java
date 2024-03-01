package com.leetcode.hot100.链表.leetcode0160;

/*
力扣-160-相交链表
hot100-链表
 */

import com.leetcode.util.ListNode;

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

}
