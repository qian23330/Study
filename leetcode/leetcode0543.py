# 力扣-543-翻转二叉树
# hot100-二叉树-DFS


from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def __init__(self):
        self.ans = 1

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.depth(root)
        return self.ans - 1

    def depth(self, node):
        # 访问到空节点了，返回0
        if not node:
            return 0
        # 左儿子为根的子树的深度
        L = self.depth(node.left)
        # 右儿子为根的子树的深度
        R = self.depth(node.right)
        # 计算d_node即L+R+1 并更新ans
        self.ans = max(self.ans, L + R + 1)
        # 返回该节点为根的子树的深度
        return max(L, R) + 1



if __name__ == '__main__':
    tree = construct_binary_tree()
    print(Solution().diameterOfBinaryTree(tree))
