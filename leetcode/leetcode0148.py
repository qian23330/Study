### 力扣-148-排序链表 ###
# 链表-归并排序


from linkedlist.linkedlist import ListNode, print_linked_list, create_linked_list_from_user_input


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head  # termination.
        # cut the LinkedList at the mid-index.
        slow, fast = head, head.next
        while fast and fast.next:
            fast, slow = fast.next.next, slow.next
        mid, slow.next = slow.next, None  # save and cut.
        # recursive for cutting.
        left, right = self.sortList(head), self.sortList(mid)
        # merge `left` and `right` linked list and return it.
        h = res = ListNode(0)
        while left and right:
            if left.val < right.val:
                h.next, left = left, left.next
            else:
                h.next, right = right, right.next
            h = h.next
        h.next = left if left else right
        return res.next


if __name__ == '__main__':
    head = create_linked_list_from_user_input()
    result = Solution().sortList(head)
    print_linked_list(result)
