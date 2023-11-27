### 力扣-0107-二叉树的层序遍历2 ###
# 二叉树-层序遍历


import collections
from typing import Optional, List
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        queue = collections.deque([root])
        result = []
        while queue:
            level = []
            for _ in range(len(queue)):
                cur = queue.popleft()
                level.append(cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            result.append(level)
        return result[::-1]


if __name__ == '__main__':
    list = list(map(int, input().split()))
    root = construct_binary_tree(list)
    print(Solution().levelOrderBottom(root))
