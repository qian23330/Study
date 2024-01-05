# 力扣-236-二叉树的最近公共祖先
# 二叉树-递归


from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        if not root or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if not left:
            return right
        if not right:
            return left
        return root


if __name__ == '__main__':
    root = construct_binary_tree()
    p = TreeNode(int(input()))
    q = TreeNode(int(input()))
    result_tree = Solution().lowestCommonAncestor(root, p, q)
    print(result_tree.val)
