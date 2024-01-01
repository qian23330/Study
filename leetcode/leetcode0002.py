### 力扣-2-两数相加 ###
# 链表


from typing import Optional
from linkedlist.linkedlist import ListNode, create_linked_list_from_user_input, print_linked_list


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        pre = ListNode(0)
        cur = pre
        carry = 0
        while l1 or l2:
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0
            sum = x + y + carry

            carry = sum // 10
            sum = sum % 10
            cur.next = ListNode(sum)

            cur = cur.next
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next

        if carry == 1:
            cur.next = ListNode(carry)

        return pre.next


if __name__ == '__main__':
    list1 = create_linked_list_from_user_input()
    list2 = create_linked_list_from_user_input()
    res = Solution().addTwoNumbers(list1, list2)
    print_linked_list(res)
