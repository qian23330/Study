package com.leetcode.hot100.链表.leetcode0141;

/*
力扣-141-环形链表
hot100-链表-哈希/双指针
 */

import com.leetcode.commons.LinkedlistSolution;
import com.leetcode.commons.ListNode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] values = scanner.nextLine().split(" ");
        System.out.println("请输入环形链表连接点pos：");
        int pos = scanner.nextInt();
        ListNode head = LinkedlistSolution.buildCircularLinkedList(values, pos);
        System.out.println(new Solution().hasCycle(head));
    }
}
