### 力扣-25-K个一组翻转链表 ###
# 链表-递归


from linkedlist.linkedlist import ListNode, print_linked_list, create_linked_list_from_user_input


class Solution:
    # 翻转一个子链表，并且返回新的头与尾
    def reverse(self, head: ListNode, tail: ListNode):
        prev = tail.next
        p = head
        while prev != tail:
            nex = p.next
            p.next = prev
            prev = p
            p = nex
        return tail, head

    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        hair = ListNode(0)
        hair.next = head
        pre = hair

        while head:
            tail = pre
            # 查看剩余部分长度是否大于等于 k
            for i in range(k):
                tail = tail.next
                if not tail:
                    return hair.next
            nex = tail.next
            head, tail = self.reverse(head, tail)
            # 把子链表重新接回原链表
            pre.next = head
            tail.next = nex
            pre = tail
            head = tail.next

        return hair.next


if __name__ == '__main__':
    h = create_linked_list_from_user_input()
    n = int(input())
    result = Solution().reverseKGroup(h, n)
    print_linked_list(result)
