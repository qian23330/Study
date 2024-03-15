### 力扣-491-递增子序列 ###
# 回溯


class Solution:
    def findSubsequences(self, nums):
        result = []
        path = []
        self.backtracking(nums, 0, path, result)
        return result

    def backtracking(self, nums, startIndex, path, result):
        if len(path) > 1:
            result.append(path[:])  # 注意要使用切片将当前路径的副本加入结果集
            # 注意这里不要加return，要取树上的节点
        uset = set()  # 使用集合对本层元素进行去重

        for i in range(startIndex, len(nums)):
            if (path and nums[i] < path[-1]) or nums[i] in uset:
                continue
            uset.add(nums[i])  # 记录这个元素在本层用过了，本层后面不能再用了
            path.append(nums[i])
            self.backtracking(nums, i + 1, path, result)
            path.pop()


if __name__ == '__main__':
    nums = list(map(int, input().split()))
    print(Solution().findSubsequences(nums))
