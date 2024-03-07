# 力扣-0112-路径总和
# 二叉树遍历-dfs 


from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
        if not root.left and not root.right and sum == root.val:
            return True
        return self.hasPathSum(root.left, sum - root.val) or self.hasPathSum(root.right, sum - root.val)
    

if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    n = int(input())
    print(Solution().hasPathSum(root, n))