# 力扣-0098-验证二叉搜索树
# 二叉搜索树-中序遍历


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


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


def build_tree(nodes, i, n):
    root = None
    if i < n and nodes[i] is not None:
        root = TreeNode(nodes[i])
        root.left = build_tree(nodes, 2 * i + 1, n)
        root.right = build_tree(nodes, 2 * i + 2, n)
    return root


if __name__ == '__main__':
    list = input().split()
    list = [int(val) if val != "null" else None for val in list]
    root = build_tree(list, 0, len(list))

    result_tree = Solution().isValidBST(root)
    print(result_tree)
