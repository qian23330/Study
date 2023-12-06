### 力扣-0094-二叉树的中序遍历 ###
# 二叉树


from typing import List
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []

        left = self.inorderTraversal(root.left)
        right = self.inorderTraversal(root.right)

        return left + [root.val] + right


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    print(Solution().inorderTraversal(root))