# 力扣-LCR079-子集
# 回溯


from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.dfs(nums, 0, [], result)
        return result

    def dfs(self, nums, startIndex, path, result):
        result.append(path[:])
        for i in range(startIndex, len(nums)):
            path.append(nums[i])
            self.dfs(nums, i + 1, path, result)
            path.pop()


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().subsets(nums))
