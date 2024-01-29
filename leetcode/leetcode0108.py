# 力扣-108-将有序数组转换为二叉搜索树
# hot100-二叉搜索树


from typing import List, Optional
from tree.tree import TreeNode, print_tree


class Solution:
    def traversal(self, nums: List[int], left: int, right: int) -> Optional[TreeNode]:
        if left > right:
            return None

        mid = left + (right - left) // 2
        root = TreeNode(nums[mid])
        root.left = self.traversal(nums, left, mid - 1)
        root.right = self.traversal(nums, mid + 1, right)
        return root

    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        root = self.traversal(nums, 0, len(nums) - 1)
        return root


if __name__ == '__main__':
    nums = [int(x) for x in input().split()]
    result_tree = Solution().sortedArrayToBST(nums)
    print_tree(result_tree)
