### 力扣-0018-四数之和 ###
# 哈希表/双指针+剪枝+去重

from typing import List


# 双指针
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        result = []
        for i in range(n):
            if nums[i] > target > 0 and nums[i] > 0:  # 剪枝（可省）
                break
            if i > 0 and nums[i] == nums[i - 1]:  # 去重
                continue
            for j in range(i + 1, n):
                if nums[i] + nums[j] > target > 0:  # 剪枝（可省）
                    break
                if j > i + 1 and nums[j] == nums[j - 1]:  # 去重
                    continue
                left, right = j + 1, n - 1
                while left < right:
                    s = nums[i] + nums[j] + nums[left] + nums[right]
                    if s == target:
                        result.append([nums[i], nums[j], nums[left], nums[right]])
                        while left < right and nums[left] == nums[left + 1]:
                            left += 1
                        while left < right and nums[right] == nums[right - 1]:
                            right -= 1
                        left += 1
                        right -= 1
                    elif s < target:
                        left += 1
                    else:
                        right -= 1
        return result

    # def fourSum(self, nums, target):
    #     """
    #     :type nums: List[int]
    #     :type target: int
    #     :rtype: List[List[int]]
    #     """
    #     # 创建一个字典来存储输入列表中每个数字的频率
    #     freq = {}
    #     for num in nums:
    #         freq[num] = freq.get(num, 0) + 1
    #
    #     # 创建一个集合来存储最终答案，并遍历4个数字的所有唯一组合
    #     ans = set()
    #     for i in range(len(nums)):
    #         for j in range(i + 1, len(nums)):
    #             for k in range(j + 1, len(nums)):
    #                 val = target - (nums[i] + nums[j] + nums[k])
    #                 if val in freq:
    #                     # 确保没有重复
    #                     count = (nums[i] == val) + (nums[j] == val) + (nums[k] == val)
    #                     if freq[val] > count:
    #                         ans.add(tuple(sorted([nums[i], nums[j], nums[k], val])))
    #
    #     return [list(x) for x in ans]


if __name__ == '__main__':
    input_str = input()
    n = int(input())
    nums = list(map(int, input_str.split()))
    print(Solution().fourSum(nums, n))
