# 力扣-142-环形链表2
# hot100-链表


from linkedlist.linkedlist import ListNode, create_linked_list_from_user_input


class Solution:
    def detectCycle(self, head: ListNode):
        visited = set()

        while head:
            if head in visited:
                return head
            visited.add(head)
            head = head.next

        return None


if __name__ == '__main__':
    head = create_linked_list_from_user_input()
    print(Solution().detectCycle(head))
