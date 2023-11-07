### 力扣-0019-删除链表倒数第N个结点 ###
# 链表


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    @staticmethod
    def removeNthFromEnd(head: ListNode, n: int) -> ListNode:
        # 创建一个虚拟节点，并将其下一个指针设置为链表的头部
        dummy_head = ListNode(0, head)

        # 创建两个指针，慢指针和快指针，并将它们初始化为虚拟节点
        slow = fast = dummy_head

        # 快指针比慢指针快 n+1 步
        for i in range(n + 1):
            fast = fast.next

        # 移动两个指针，直到快速指针到达链表的末尾
        while fast:
            slow = slow.next
            fast = fast.next

        # 通过更新第 (n-1) 个节点的 next 指针删除第 n 个节点
        slow.next = slow.next.next

        return dummy_head.next

    @staticmethod
    def create_linked_list_from_user_input():
        values = input("请输入一系列整数，以空格分隔：").split()
        head = ListNode(int(values[0]))
        current = head

        for val in values[1:]:
            current.next = ListNode(int(val))
            current = current.next

        return head

    @staticmethod
    def print_linked_list(head):
        current = head
        while current:
            print(current.val, end=" -> ")
            current = current.next
        print("None")


if __name__ == '__main__':
    user_input_linked_list = Solution.create_linked_list_from_user_input()
    # 打印原始链表
    print("原始链表:")
    Solution.print_linked_list(user_input_linked_list)
    n = int(input("要删除倒数第几个呢？"))
    user_input_linked_list = Solution.removeNthFromEnd(user_input_linked_list, n)
    # 打印翻转后的链表
    print("翻转后的链表:")
    Solution.print_linked_list(user_input_linked_list)
