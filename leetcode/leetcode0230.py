# 力扣-230-二叉搜索树中第K小的元素
# 二叉搜索树-中序遍历


from typing import Optional
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def __init__(self):
        self.vec = []

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.vec = []  # 清空数组
        self.traversal(root)
        # print(self.vec)
        return self.vec[k-1]

    def traversal(self, root):
        if root is None:
            return
        self.traversal(root.left)
        self.vec.append(root.val)  # 将二叉搜索树转换为有序数组
        self.traversal(root.right)


if __name__ == '__main__':
    tree = construct_binary_tree()
    n = int(input())
    result = Solution().kthSmallest(tree, n)
    print(result)