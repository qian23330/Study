# 力扣-0538-把二叉搜索树转换为累加树
# 二叉搜索树


from tree import tree


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


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
    list = input().split()
    root = tree.construct_binary_tree(list)

    result_tree = Solution().convertBST(root)
    tree.print_tree(result_tree)
