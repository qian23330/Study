# 力扣-0669-修剪二叉搜索树
# 二叉搜索树


from tree.tree import TreeNode, construct_binary_tree, print_tree


class Solution:
    def trimBST(self, root: TreeNode, low: int, high: int) -> TreeNode:
        if root is None:
            return None
        if root.val < low:
            # 寻找符合区间 [low, high] 的节点
            return self.trimBST(root.right, low, high)
        if root.val > high:
            # 寻找符合区间 [low, high] 的节点
            return self.trimBST(root.left, low, high)
        root.left = self.trimBST(root.left, low, high)  # root.left 接入符合条件的左孩子
        root.right = self.trimBST(root.right, low, high)  # root.right 接入符合条件的右孩子
        return root


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    low = int(input())
    high = int(input())

    result_tree = Solution().trimBST(root, low, high)
    print_tree(result_tree)
