### 力扣-0237-删除链表中的节点 ###
# 链表-删除元素


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    @staticmethod
    def deleteNode(node):
        node.val = node.next.val
        node.next = node.next.next

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
    # 创建链表
    user_input_linked_list = Solution.create_linked_list_from_user_input()

    # 打印原始链表
    print("原始链表:")
    Solution.print_linked_list(user_input_linked_list)

    # 选择要删除的节点
    node_to_delete = int(input("请输入要删除的节点的值："))

    current = user_input_linked_list
    while current:
        if current.val == node_to_delete:
            Solution.deleteNode(current)
            break
        current = current.next

    # 打印删除后的链表
    print("删除后的链表:")
    Solution.print_linked_list(user_input_linked_list)

