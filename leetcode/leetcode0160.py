# 力扣-160-相交链表
# hot100-链表-双指针


from typing import Optional
from linkedlist.linkedlist import ListNode


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        A, B = headA, headB
        while A != B:
            A = A.next if A else headB
            B = B.next if B else headA
        return A

