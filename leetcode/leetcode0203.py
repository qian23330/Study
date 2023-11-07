### 力扣-0203-移除链表元素 ###
# 链表-删除元素


from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    @staticmethod
    def removeElements(head: Optional[ListNode], val: int) -> Optional[ListNode]:
        # 创建虚拟头部节点以简化删除过程
        dummy_head = ListNode(next=head)

        # 遍历列表并删除值为val的节点
        current = dummy_head
        while current.next:
            if current.next.val == val:
                current.next = current.next.next
            else:
                current = current.next

        return dummy_head.next

    @staticmethod
    def create_linked_list_from_user_input():
        values = input("请输入一系列整数，以空格分隔：").split()
        head = None
        tail = None

        for val in values:
            new_node = ListNode(int(val))
            if head is None:
                head = new_node
                tail = new_node
            else:
                tail.next = new_node
                tail = new_node

        return head


if __name__ == '__main__':
    # 创建链表
    user_input_linked_list = Solution.create_linked_list_from_user_input()

    val = int(input("请输入待删除的节点："))
    current = Solution.removeElements(user_input_linked_list, val)
    # print(current.val)
    while current:
        print(current.val, end=" -> ")
        current = current.next
    print("None")

