# 力扣-0110-平衡二叉树
# 二叉树遍历-前序遍历


from typing import Optional
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.get_hight(root) != -1

    def get_hight(self, node):
        if not node:
            return 0
        left = self.get_hight(node.left)
        right = self.get_hight(node.right)
        if left == -1 or right == -1 or abs(left - right) > 1:
            return -1
        return max(left, right) + 1


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    print(Solution().isBalanced(root))
