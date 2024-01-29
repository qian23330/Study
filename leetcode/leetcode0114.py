# 力扣-114-二叉树展开为链表
# hot100-二叉树-前序遍历


from typing import Optional
from tree.tree import TreeNode


class Solution:
    def __init__(self):
        self.res = []

    def traverse(self, root: Optional[TreeNode]):
        if root:
            self.res.append(root)
            self.traverse(root.left)
            self.traverse(root.right)

    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.traverse(root)
        for i in range(1, len(self.res)):
            prev, curr = self.res[i-1], self.res[i]
            prev.left = None
            prev.right = curr

