### 力扣-0199-二叉树的右视图 ###
# 二叉树-层序遍历


import collections
from typing import List
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        queue = collections.deque([root])
        right_view = []

        while queue:
            level_size = len(queue)
            for i in range(level_size):
                node = queue.popleft()
                if i == level_size - 1:
                    right_view.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return right_view


if __name__ == '__main__':
    list = list(map(int, input().split()))
    root = construct_binary_tree(list)
    print(Solution().rightSideView(root))