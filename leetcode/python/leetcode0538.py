# 力扣-0538-把二叉搜索树转换为累加树
# 二叉搜索树


from tree.tree import TreeNode, construct_binary_tree, print_tree


class Solution:
    def __init__(self):
        self.pre = None

    def convertBST(self, root: TreeNode) -> TreeNode:
        self.pre = 0  # 记录前一个节点的数值
        self.traversal(root)
        return root

    def traversal(self, cur):
        if cur is None:
            return
        self.traversal(cur.right)
        cur.val += self.pre
        self.pre = cur.val
        self.traversal(cur.left)


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)

    result_tree = Solution().convertBST(root)
    print_tree(result_tree)
