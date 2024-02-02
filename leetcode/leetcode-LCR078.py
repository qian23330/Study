# 力扣-LCR078-合并K个升序链表
# 链表-分治


from typing import List
from linkedlist.linkedlist import ListNode


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        length = len(lists)
        if length == 0:
            return None
        if length == 1:
            return lists[0]
        left = self.mergeKLists(lists[:length // 2])
        right = self.mergeKLists(lists[length // 2:])
        return self.mergeTwoLists(left, right)

    def mergeTwoLists(self, list1: ListNode, list2: ListNode):
        cur = dummy = ListNode(0)
        while list1 and list2:
            if list1.val < list2.val:
                cur.next = list1
                list1 = list1.next
            else:
                cur.next = list2
                list2 = list2.next
            cur = cur.next
        cur.next = list1 if list1 else list2
        return dummy.next
