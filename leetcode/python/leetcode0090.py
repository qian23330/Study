### 力扣-90-子集2 ###
# 回溯


class Solution:
    def subsetsWithDup(self, nums):
        result = []
        path = []
        nums.sort()  # 去重需要排序
        self.backtracking(nums, 0, path, result)
        return result

    def backtracking(self, nums, startIndex, path, result):
        result.append(path[:])  # 收集子集
        for i in range(startIndex, len(nums)):
            # 而我们要对同一树层使用过的元素进行跳过
            if i > startIndex and nums[i] == nums[i - 1]:
                continue
            path.append(nums[i])
            self.backtracking(nums, i + 1, path, result)
            path.pop()


if __name__ == '__main__':
    nums = list(map(int, input().split()))
    print(Solution().subsetsWithDup(nums))
    