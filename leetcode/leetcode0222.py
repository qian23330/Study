# 力扣-0222-完全二叉树的节点个数
# 二叉树-层序遍历


from tree.tree import TreeNode, construct_binary_tree


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
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    print(Solution().countNodes(root))
