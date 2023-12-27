### 力扣-141-环形链表 ###
# 链表-哈希


from typing import Optional
from linkedlist.linkedlist import ListNode


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        dic = {}
        cur = head

        while cur is not None:
            dic[cur] = dic.get(cur, 0) + 1
            if dic[cur] == 2:
                return True
            cur = cur.next

        return False
