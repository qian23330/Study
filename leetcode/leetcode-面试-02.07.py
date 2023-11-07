### 力扣-面试-02.07-链表相交 ###
# 链表


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode):
        dis = self.getLength(headA) - self.getLength(headB)

        # 通过移动较长的链表，使两链表长度相等
        if dis > 0:
            headA = self.moveForward(headA, dis)
        else:
            headB = self.moveForward(headB, abs(dis))

        # 将两个头向前移动，直到它们相交
        while headA and headB:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next

        return None

    def getLength(self, head: ListNode) -> int:
        length = 0
        while head:
            length += 1
            head = head.next
        return length

    def moveForward(self, head: ListNode, steps: int) -> ListNode:
        while steps > 0:
            head = head.next
            steps -= 1
        return head

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
    user_input_linked_list_1 = Solution.create_linked_list_from_user_input()
    user_input_linked_list_2 = Solution.create_linked_list_from_user_input()
    # 打印原始链表
    print("链表1:")
    Solution.print_linked_list(user_input_linked_list_1)
    print("链表1:")
    Solution.print_linked_list(user_input_linked_list_2)
    node = Solution().getIntersectionNode(user_input_linked_list_1, user_input_linked_list_2)
    # 打印翻转后的链表
    if node:
        print("交点:", node.val)
    else:
        print("没有交点")