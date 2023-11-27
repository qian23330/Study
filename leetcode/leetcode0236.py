# 力扣-0236-二叉树的最近公共祖先
# 二叉搜索树


from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def lowestCommonAncestor(self, root, p, q):
        if root == q or root == p or root is None:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left is not None and right is not None:
            return root

        if left is None and right is not None:
            return right
        elif left is not None and right is None:
            return left
        else:
            return None


if __name__ == '__main__':
    list = input().split()
    root = construct_binary_tree(list)
    p = TreeNode(int(input()))
    q = TreeNode(int(input()))

    result_tree = Solution().lowestCommonAncestor(root, p, q)
    print(result_tree.val)
