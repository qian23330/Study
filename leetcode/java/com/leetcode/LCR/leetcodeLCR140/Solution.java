package com.leetcode.LCR.leetcodeLCR140;

/*
力扣-140-训练计划 II
LCR-链表-双指针
 */

import com.leetcode.utils.LinkedlistSolution;
import com.leetcode.utils.ListNode;

import java.util.Scanner;

class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode dummy = new ListNode(-1), slow = dummy, fast = dummy;
        dummy.next = head;
        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        int cnt = scanner.nextInt();
        System.out.println(new Solution().trainingPlan(head, cnt).val);
    }
}
