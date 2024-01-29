# 力扣-234-回文链表
# hot100-链表


from linkedlist.linkedlist import ListNode, create_linked_list_from_user_input


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        vals = []
        current_node = head
        while current_node is not None:
            vals.append(current_node.val)
            current_node = current_node.next
        return vals == vals[::-1]


if __name__ == '__main__':
    head = create_linked_list_from_user_input()
    print(Solution().isPalindrome(head))
