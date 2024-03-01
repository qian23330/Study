package com.leetcode.hot100.链表.leetcode0023;

/*
力扣-23-合并K个有序链表
hot100-链表
 */

import com.leetcode.util.LinkedlistSolution;
import com.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    // 合并从 lists[i] 到 lists[j-1] 的链表
    private ListNode mergeKLists(ListNode[] lists, int i, int j) {
        int m = j - i;
        if (m == 0) return null;
        if (m == 1) return lists[i];
        ListNode left = mergeKLists(lists, i, i + m / 2);
        ListNode right = mergeKLists(lists, i + m / 2, j);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("请输入若干个整数链表，每个链表一行，链表中的数字用空格隔开：");
        Scanner scanner = new Scanner(System.in);
        List<ListNode> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            String[] input = line.split(" ");
            ListNode node = LinkedlistSolution.createLinkedList(input);
            list.add(node);
        }
        ListNode[] lists = list.toArray(new ListNode[0]);
        if (lists.length == 0) {
            System.out.println("[]");
        } else {
            ListNode node = new Solution().mergeKLists(lists);
            LinkedlistSolution.printLinkedList(node);
        }

    }
}
