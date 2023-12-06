# 力扣-0101-对称二叉树
# 二叉树-后序遍历


from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.compare(root.left, root.right)

    def compare(self, left, right):
        # 首先排除空节点的情况
        if left == None and right != None:
            return False
        elif left != None and right == None:
            return False
        elif left == None and right == None:
            return True
        # 排除了空节点，再排除数值不相同的情况
        elif left.val != right.val:
            return False

        # 此时就是：左右节点都不为空，且数值相同的情况
        # 此时才做递归，做下一层的判断
        outside = self.compare(left.left, right.right)  # 左子树：左、 右子树：右
        inside = self.compare(left.right, right.left)  # 左子树：右、 右子树：左
        isSame = outside and inside  # 左子树：中、 右子树：中 （逻辑处理）
        return isSame


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    print(Solution().isSymmetric(root))
