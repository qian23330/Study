# 力扣-0404-左子叶之和
# 二叉树遍历-后序遍历


from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def sumOfLeftLeaves(self, root):
        if root is None:
            return 0
        leftValue = 0
        if root.left is not None and root.left.left is None and root.left.right is None:
            leftValue = root.left.val
        return leftValue + self.sumOfLeftLeaves(root.left) + self.sumOfLeftLeaves(root.right)
    
    
if __name__ == '__main__':
    list = list(map(int, input().split()))
    root = construct_binary_tree(list)
    print(Solution().sumOfLeftLeaves(root))