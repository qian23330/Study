# 力扣-0530-二叉搜索树的最小绝对差
# 二叉搜索树-中序遍历


from tree.tree import construct_binary_tree


class Solution:
    def __init__(self):
        self.vec = []

    def traversal(self, root):
        if root is None:
            return
        self.traversal(root.left)
        self.vec.append(root.val)  # 将二叉搜索树转换为有序数组
        self.traversal(root.right)

    def getMinimumDifference(self, root):
        self.vec = []
        self.traversal(root)
        if len(self.vec) < 2:
            return 0
        result = float('inf')
        for i in range(1, len(self.vec)):
            # 统计有序数组的最小差值
            result = min(result, self.vec[i] - self.vec[i - 1])
        return result


if __name__ == '__main__':
    list = input().split()
    root = construct_binary_tree(list)

    result_tree = Solution().getMinimumDifference(root)
    print(result_tree)
