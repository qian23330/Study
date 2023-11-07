# 力扣-0429-N叉树的层序遍历
# 二叉树遍历-层序遍历

import collections
from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    # 迭代法
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []

        result = []
        queue = collections.deque([root])

        while queue:
            level_size = len(queue)
            level = []

            for _ in range(level_size):
                node = queue.popleft()
                level.append(node.val)

                for child in node.children:
                    queue.append(child)

            result.append(level)

        return result
    
    # 递归法
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root: 
            return []
        
        result=[]

        def traversal(root, depth):
            if len(result) == depth:
                result.append([])
            result[depth].append(root.val)
            if root.children:
                for i in range(len(root.children)):
                    traversal(root.children[i], depth + 1)

        traversal(root, 0)
        return result


if __name__ == '__main__':
    root = Node(1)
    root.left = Node(2)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right = Node(3)
    root.right.left = Node(6)
    root.right.right = Node(7)

    print(Solution().levelOrder(root))
