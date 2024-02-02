# 力扣-LCR077-排序链表
# 链表-归并排序


from linkedlist.linkedlist import ListNode, print_linked_list, create_linked_list_from_user_input


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        while not head or not head.next:
            return head
        slow, fast = head, head.next
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        mid = slow.next
        slow.next = None
        left, right = self.sortList(head), self.sortList(mid)
        cur = dummy = ListNode(0)
        while left and right:
            if left.val < right.val:
                cur.next = left
                left = left.next
            else:
                cur.next = right
                right = right.next
            cur = cur.next
        cur.next = left if left else right
        return dummy.next


if __name__ == '__main__':
    head = create_linked_list_from_user_input()
    result = Solution().sortList(head)
    print_linked_list(result)
