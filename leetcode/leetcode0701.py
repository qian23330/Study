# 力扣-0701-二叉搜索树中的插入操作
# 二叉搜索树-中序遍历


from tree.tree import TreeNode, construct_binary_tree, print_tree


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
    list = list(map(int, input().split()))
    root = construct_binary_tree(list)
    val = int(input())

    result_tree = Solution().insertIntoBST(root, val)
    print_tree(result_tree)
