### 力扣-0203-反转链表 ###
# 链表


# 双指针
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    @staticmethod
    def reverseList(head: ListNode) -> ListNode:
        cur = head
        pre = None
        while cur:
            temp = cur.next     # 保存一下 cur的下一个节点，因为接下来要改变cur->next
            cur.next = pre      # 反转
            pre = cur           # 更新pre、cur指针
            cur = temp
        return pre

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
    user_input_linked_list = Solution.reverseList(user_input_linked_list)
    # 打印翻转后的链表
    print("翻转后的链表:")
    Solution.print_linked_list(user_input_linked_list)

# 递归
# class Solution:
#     def reverseList(self, head: ListNode) -> ListNode:
#         return self.reverse(head, None)
#     def reverse(self, cur: ListNode, pre: ListNode) -> ListNode:
#         if cur == None:
#             return pre
#         temp = cur.next
#         cur.next = pre
#         return self.reverse(temp, cur)

