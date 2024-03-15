class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# 随机链表
class Node:
    def __init__(self, x: int, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random


class DLinkedNode:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


def create_linked_list_from_user_input():
    values = input("请输入一系列整数，以空格分隔：").split()
    if len(values) != 0:
        head = ListNode(int(values[0]))
        current = head
        for val in values[1:]:
            current.next = ListNode(int(val))
            current = current.next
    else:
        head = None
    return head


def print_linked_list(head):
    current = head
    if head is None:
        print([])
    else:
        while current:
            print(current.val, end=" -> ")
            current = current.next
        print("None")
