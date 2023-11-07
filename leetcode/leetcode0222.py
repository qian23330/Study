# 力扣-0101-对称二叉树
# 二叉树-后序遍历


class TreeNode:
    def __init__(self, val: int = 0, left: 'TreeNode' = None, right: 'TreeNode' = None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # 递归
    def countNodes(self, root: TreeNode) -> int:
        if not root:
            return 0
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)

    # 利用完全二叉树特性
    def countNodes(self, root: TreeNode) -> int:
        if not root:
            return 0
        count = 0
        left = root.left
        right = root.right
        while left and right:
            count += 1
            left = left.left
            right = right.right
        if not left and not right:  # 如果同时到底说明是满二叉树，反之则不是
            return (2 << count) - 1
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right = TreeNode(3)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)

    print(Solution().countNodes(root))
