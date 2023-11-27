### 力扣-0144-二叉树的前序遍历 ###
# 二叉树


from typing import List
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        left = self.preorderTraversal(root.left)
        right = self.preorderTraversal(root.right)

        return [root.val] + left + right


if __name__ == '__main__':
    list = list(map(int, input().split()))
    root = construct_binary_tree(list)
    print(Solution().preorderTraversal(root))
