# 力扣-101-对称二叉树
# 二叉树-递归


from tree.tree import construct_binary_tree


class Solution:
    def isSymmetric(self, root):
        if not root:
            return True
        # 用递归函数，比较左节点，右节点
        return self.dfs(root.left, root.right)

    def dfs(self, left, right):
        # 递归的终止条件是两个节点都为空
        # 或者两个节点中有一个为空
        # 或者两个节点的值不相等
        if not (left or right):
            return True
        if not (left and right):
            return False
        if left.val != right.val:
            return False
        return self.dfs(left.left, right.right) and self.dfs(left.right, right.left)




if __name__ == '__main__':
    root = construct_binary_tree()
    print(Solution().isSymmetric(root))
