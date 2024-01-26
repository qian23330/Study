# 力扣-169-多数元素
# 数组-哈希-分治


from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        dic = {}
        for i in nums:
            dic[i] = dic.get(i, 0) + 1
        for key, val in dic.items():
            if val > (len(nums) // 2):
                return key

        return -1


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().majorityElement(nums))
