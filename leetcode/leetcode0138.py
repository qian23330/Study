# 力扣-138-随机链表的复制
# hot100-链表-哈希


from linkedlist.linkedlist import Node


class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return
        dic = {}
        # 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        cur = head
        while cur:
            dic[cur] = Node(cur.val)
            cur = cur.next
        cur = head
        # 4. 构建新节点的 next 和 random 指向
        while cur:
            dic[cur].next = dic.get(cur.next)
            dic[cur].random = dic.get(cur.random)
            cur = cur.next
        # 5. 返回新链表的头节点
        return dic[head]

