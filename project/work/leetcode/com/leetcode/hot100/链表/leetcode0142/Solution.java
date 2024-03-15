package com.leetcode.hot100.链表.leetcode0142;

/*
力扣-142-环形链表 II
hot100-链表-哈希/双指针
 */

import com.leetcode.utils.LinkedlistSolution;
import com.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) {
                return head;
            }
            seen.add(head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] values = scanner.nextLine().split(" ");
        System.out.println("请输入环形链表连接点pos：");
        int pos = scanner.nextInt();
        ListNode head = LinkedlistSolution.buildCircularLinkedList(values, pos);
        System.out.println(new Solution().detectCycle(head).val);
    }
}
