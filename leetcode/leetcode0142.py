### 力扣-0142-环形链表2 ###
# 链表


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            # If there is a cycle, the slow and fast pointers will eventually meet
            if slow == fast:
                # Move one of the pointers back to the start of the list
                slow = head
                while slow != fast:
                    slow = slow.next
                    fast = fast.next
                return slow
        # If there is no cycle, return None
        return None


# class Solution:
#     def detectCycle(self, head: ListNode) -> ListNode:
#         visited = set()
#
#         while head:
#             if head in visited:
#                 return head
#             visited.add(head)
#             head = head.next
#
#         return None

