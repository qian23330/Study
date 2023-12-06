# 力扣-0654-最大二叉树
# 二叉树构造-前序


from typing import List
from tree.tree import TreeNode, print_tree


class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        if not nums:
            return None
        max_val = max(nums)
        max_index = nums.index(max_val)
        node = TreeNode(max_val)
        node.left = self.constructMaximumBinaryTree(nums[:max_index])
        node.right = self.constructMaximumBinaryTree(nums[max_index + 1:])
        return node


if __name__ == '__main__':
    list = [x for x in input().split()]
    result_tree = Solution().constructMaximumBinaryTree(list)
    print_tree(result_tree)

