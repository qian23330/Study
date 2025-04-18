# 力扣-104-二叉树的最大深度
# hot100-二叉树遍历-层序遍历


import collections
from tree.tree import construct_binary_tree, TreeNode


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        depth = 0
        queue = collections.deque([root])
        
        while queue:
            depth += 1
            for _ in range(len(queue)):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        
        return depth


if __name__ == '__main__':
    root = construct_binary_tree()
    print(Solution().maxDepth(root))
