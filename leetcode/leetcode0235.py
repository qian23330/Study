# 力扣-0235-二叉搜索树的最近公共祖先
# 二叉搜索树


from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def lowestCommonAncestor(self, root, p, q):
        if root.val > p.val and root.val > q.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif root.val < p.val and root.val < q.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root


if __name__ == '__main__':
    list = input().split()
    root = construct_binary_tree(list)
    p = TreeNode(int(input()))
    q = TreeNode(int(input()))

    result_tree = Solution().lowestCommonAncestor(root, p, q)
    print(result_tree.val)
