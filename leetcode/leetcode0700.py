# 力扣-0700-二叉搜索树中的搜索
# 二叉搜索树


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        # 为什么要有返回值:
        #   因为搜索到目标节点就要立即return，
        #   这样才是找到节点就返回（搜索某一条边），如果不加return，就是遍历整棵树了。

        if not root or root.val == val:
            return root

        if root.val > val:
            return self.searchBST(root.left, val)

        if root.val < val:
            return self.searchBST(root.right, val)

    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        while root:
            if val < root.val:
                root = root.left
            elif val > root.val:
                root = root.right
            else:
                return root
        return None


# 从输入的列表构建树
def build_tree(nodes, i, n):
    root = None
    if i < n and nodes[i] is not None:
        root = TreeNode(nodes[i])
        root.left = build_tree(nodes, 2 * i + 1, n)
        root.right = build_tree(nodes, 2 * i + 2, n)
    return root


def print_tree(root):
    if root:
        print(root.val, end=" ")
        print_tree(root.left)
        print_tree(root.right)


if __name__ == '__main__':
    list = input().split()
    list = [int(val) if val != "null" else None for val in list]
    root = build_tree(list, 0, len(list))
    node = int(input())

    result_tree = Solution().searchBST(root, node)
    print_tree(result_tree)
