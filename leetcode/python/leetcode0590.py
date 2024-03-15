# 力扣-590-N 叉树的后序遍历
# 每日一题-dfs


from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        result = []

        def dfs(node: 'Node'):
            if not node:
                return
            for i in node.children:
                dfs(i)
            result.append(node.val)

        dfs(root)
        return result
