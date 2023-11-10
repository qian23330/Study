# 力扣-0617-合并二叉树
# 二叉树合并-dfs


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def mergeTrees(self, root1: TreeNode, root2: TreeNode) -> TreeNode:
        # 递归终止条件:
        #  但凡有一个节点为空, 就立刻返回另外一个. 如果另外一个也为None就直接返回None.
        if not root1:
            return root2
        if not root2:
            return root1
        # 上面的递归终止条件保证了代码执行到这里root1, root2都非空.
        root = TreeNode()  # 创建新节点
        root.val += root1.val + root2.val  # 中
        root.left = self.mergeTrees(root1.left, root2.left)  # 左
        root.right = self.mergeTrees(root1.right, root2.right)  # 右

        return root   # ⚠️注意: 本题我们创建了新节点.


# 从输入的列表构建树
def build_tree(nodes, i, n):
    root = None
    if i < n and nodes[i] is not None:
        root = TreeNode(nodes[i])
        root.left = build_tree(nodes, 2 * i + 1, n)
        root.right = build_tree(nodes, 2 * i + 2, n)
    return root


# 打印合并后的树
def print_tree(root):
    if root:
        print(root.val, end=" ")
        print_tree(root.left)
        print_tree(root.right)


if __name__ == '__main__':
    list1 = input().split()
    list2 = input().split()
    list1 = [int(val) if val != "null" else None for val in list1]
    list2 = [int(val) if val != "null" else None for val in list2]

    # 从输入的列表构建树
    root1 = build_tree(list1, 0, len(list1))
    root2 = build_tree(list2, 0, len(list2))

    # 调用合并方法
    result_tree = Solution().mergeTrees(root1, root2)
    print_tree(result_tree)






