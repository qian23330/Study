### 力扣-0001-两数之和 ###
# hot100-哈希表

from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 创建一个集合来存储我们目前看到的数字
        seen = set()
        for i, num in enumerate(nums):
            complement = target - num
            if complement in seen:
                return [nums.index(complement), i]
            seen.add(num)


if __name__ == '__main__':
    input_str = input()
    nums = list(map(int, input_str.split()))
    n = int(input())
    print(Solution().twoSum(nums, n))


# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         records = {}
#         for index, value in enumerate(nums):
#             if target - value in records:   # 遍历当前元素，并在map中寻找是否有匹配的key
#                 return [records[target - value], index]
#             records[value] = index    # 如果没找到匹配对，就把访问过的元素和下标加入到map中
#         return []
