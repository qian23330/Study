# 力扣-0098-验证二叉搜索树
# 二叉搜索树-中序遍历


from tree import tree
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

    def isValidBST(self, root):
        self.vec = []  # 清空数组
        self.traversal(root)
        for i in range(1, len(self.vec)):
            # 注意要小于等于，搜索树里不能有相同元素
            if self.vec[i] <= self.vec[i - 1]:
                return False
        return True


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)

    result_tree = Solution().isValidBST(root)
    print(result_tree)
