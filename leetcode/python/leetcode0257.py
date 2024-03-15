# 力扣-0257-二叉树的所有路径
# 二叉树遍历-前序遍历


from tree.tree import TreeNode, construct_binary_tree


# 递归法+回溯
class Solution:
    def traversal(self, cur, path, result):
        path.append(cur.val)  # 中
        if not cur.left and not cur.right:  # 到达叶子节点
            sPath = '->'.join(map(str, path))
            result.append(sPath)
            return
        if cur.left:  # 左
            self.traversal(cur.left, path, result)
            path.pop()  # 回溯
        if cur.right:  # 右
            self.traversal(cur.right, path, result)
            path.pop()  # 回溯

    def binaryTreePaths(self, root):
        result = []
        path = []
        if not root:
            return result
        self.traversal(root, path, result)
        return result


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    result_tree = Solution().binaryTreePaths(root)
    print(result_tree)