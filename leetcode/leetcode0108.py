# 力扣-0108-将有序数组转换为二叉搜索树
# 二叉搜索树


from typing import List
from tree.tree import TreeNode, print_tree


class Solution:
    def traversal(self, nums: List[int], left: int, right: int) -> TreeNode:
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
    list = list(map(int, input().split()))
    # root = tree.construct_binary_tree(list)
    result_tree = Solution().sortedArrayToBST(list)
    print_tree(result_tree)