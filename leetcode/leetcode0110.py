# 力扣-0110-平衡二叉树
# 二叉树遍历-前序遍历


from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


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


def build_tree(nodes, i, n):
    root = None
    if i < n and nodes[i] is not None:
        root = TreeNode(nodes[i])
        root.left = build_tree(nodes, 2 * i + 1, n)
        root.right = build_tree(nodes, 2 * i + 2, n)
    return root


if __name__ == '__main__':
    list = input().split()
    list = [int(val) if val != "null" else None for val in list]

    # 从输入的列表构建树
    root = build_tree(list, 0, len(list))
    print(Solution().isBalanced(root))
