# 力扣-0450-删除二叉搜索树中的节点
# 二叉搜索树


from tree.tree import construct_binary_tree, print_tree


class Solution:
    def deleteNode(self, root, key):
        if root is None:
            return root
        if root.val == key:
            if root.left is None and root.right is None:
                return None
            elif root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            else:
                cur = root.right
                while cur.left is not None:
                    cur = cur.left
                cur.left = root.left
                return root.right
        if root.val > key:
            root.left = self.deleteNode(root.left, key)
        if root.val < key:
            root.right = self.deleteNode(root.right, key)
        return root


if __name__ == '__main__':
    list = input().split()
    root = construct_binary_tree(list)
    val = int(input())

    result_tree = Solution().deleteNode(root, val)
    print_tree(result_tree)