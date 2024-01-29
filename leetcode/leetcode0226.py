# 力扣-226-翻转二叉树
# hot100-二叉树-前后层序遍历

import collections
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    # 前序遍历
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root

    # 后序遍历
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        self.invertTree(root.left)
        self.invertTree(root.right)
        root.left, root.right = root.right, root.left
        return root

    # 层序遍历
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None

        queue = collections.deque([root])
        while queue:
            for i in range(len(queue)):
                node = queue.popleft()
                node.left, node.right = node.right, node.left
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return root


if __name__ == '__main__':
    root = construct_binary_tree()
    print(Solution().invertTree(root))
