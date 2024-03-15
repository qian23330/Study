package com.leetcode.hot100.链表.leetcode0234;

/*
力扣-234-回文链表
hot100-链表
 */

import com.leetcode.utils.LinkedlistSolution;
import com.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        // 双指针判断是否回文
        int left = 0, right = res.size() - 1;
        while (left < right) {
            if (!res.get(left).equals(res.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ListNode head = LinkedlistSolution.createLinkedList(input);
        System.out.println(new Solution().isPalindrome(head));
    }
}
