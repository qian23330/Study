# 力扣-0701-二叉搜索树中的插入操作
# 二叉搜索树-中序遍历

from tree import tree


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def insertIntoBST(self, root, val):
        if root is None:
            node = TreeNode(val)
            return node

        if root.val > val:
            root.left = self.insertIntoBST(root.left, val)
        if root.val < val:
            root.right = self.insertIntoBST(root.right, val)

        return root


if __name__ == '__main__':
    list = input().split()
    root = tree.construct_binary_tree(list)
    val = int(input())

    result_tree = Solution().insertIntoBST(root, val)
    tree.print_tree(result_tree)
