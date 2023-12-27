### 力扣-面试-02.07-链表相交 ###
# 链表


from linkedlist.linkedlist import create_linked_list_from_user_input, print_linked_list


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


if __name__ == '__main__':
    user_input_linked_list_1 = create_linked_list_from_user_input()
    user_input_linked_list_2 = create_linked_list_from_user_input()
    # 打印原始链表
    print("链表1:")
    print_linked_list(user_input_linked_list_1)
    print("链表1:")
    print_linked_list(user_input_linked_list_2)
    node = Solution().getIntersectionNode(user_input_linked_list_1, user_input_linked_list_2)
    # 打印翻转后的链表
    if node:
        print("交点:", node.val)
    else:
        print("没有交点")