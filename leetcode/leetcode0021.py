# 力扣-21-合并两个有序链表
# hot100-链表


from typing import Optional
from linkedlist.linkedlist import ListNode, create_linked_list_from_user_input, print_linked_list


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        cur = dum = ListNode(0)
        while list1 and list2:
            if list1.val < list2.val:
                cur.next, list1 = list1, list1.next
            else:
                cur.next, list2 = list2, list2.next
            cur = cur.next
        cur.next = list1 if list1 else list2
        return dum.next


if __name__ == '__main__':
    l1 = create_linked_list_from_user_input()
    l2 = create_linked_list_from_user_input()
    res = Solution().mergeTwoLists(l1, l2)
    print_linked_list(res)
