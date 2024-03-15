# 力扣-0515-在每个树行中找最大值
# 二叉树遍历-层序遍历


import collections
from typing import List
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        result = []
        queue = collections.deque([root])

        while queue:
            level_size = len(queue)
            max_val = float('-inf')

            for _ in range(level_size):
                node = queue.popleft()
                max_val = max(max_val, node.val)

                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)

            result.append(max_val)

        return result


if __name__ == '__main__':
    list = [x for x in input().split()]
    root = construct_binary_tree(list)
    print(Solution().largestValues(root))
