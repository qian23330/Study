### 力扣-0237-删除链表中的节点 ###
# 链表-删除元素


from linkedlist.linkedlist import create_linked_list_from_user_input, print_linked_list


class Solution:
    def deleteNode(self, node):
        node.val = node.next.val
        node.next = node.next.next


if __name__ == '__main__':
    # 创建链表
    user_input_linked_list = create_linked_list_from_user_input()

    # 打印原始链表
    print("原始链表:")
    print_linked_list(user_input_linked_list)

    # 选择要删除的节点
    node_to_delete = int(input("请输入要删除的节点的值："))

    current = user_input_linked_list
    while current:
        if current.val == node_to_delete:
            Solution().deleteNode(current)
            break
        current = current.next

    # 打印删除后的链表
    print("删除后的链表:")
    print_linked_list(current)

