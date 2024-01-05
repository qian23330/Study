# 力扣-437-路径总和 III
# 二叉树-前缀和


import collections
from tree.tree import TreeNode, construct_binary_tree


class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> int:
        prefix = collections.defaultdict(int)
        prefix[0] = 1

        def dfs(root, curr):
            if not root:
                return 0

            ret = 0
            curr += root.val
            ret += prefix[curr - targetSum]
            prefix[curr] += 1
            ret += dfs(root.left, curr)
            ret += dfs(root.right, curr)
            prefix[curr] -= 1

            return ret

        return dfs(root, 0)


if __name__ == '__main__':
    root = construct_binary_tree()
    target = int(input())
    print(Solution().pathSum(root, target))
