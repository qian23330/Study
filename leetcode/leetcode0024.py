### 力扣-24-两两交换链表中的结点 ###
# 链表


from linkedlist.linkedlist import create_linked_list_from_user_input, print_linked_list, ListNode


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        dummy_head = ListNode(0, head)
        current = dummy_head
        # 必须有cur的下一个和下下个才能交换，否则说明已经交换结束了
        while current.next and current.next.next:
            tmp = current.next  # 防止节点修改
            tmp1 = current.next.next.next

            current.next = current.next.next
            current.next.next = tmp
            tmp.next = tmp1
            current = current.next.next
        return dummy_head.next


if __name__ == '__main__':
    user_input_linked_list = create_linked_list_from_user_input()
    # 打印原始链表
    print("原始链表:")
    print_linked_list(user_input_linked_list)
    user_input_linked_list = Solution().swapPairs(user_input_linked_list)
    # 打印翻转后的链表
    print("翻转后的链表:")
    print_linked_list(user_input_linked_list)
