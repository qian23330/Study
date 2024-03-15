### 力扣-0094-二叉树的后序遍历 ###
# 二叉树


from typing import List
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        left = self.postorderTraversal(root.left)
        right = self.postorderTraversal(root.right)

        return left + right + [root.val]


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    print(Solution().postorderTraversal(root))