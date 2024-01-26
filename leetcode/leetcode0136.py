# 力扣-136-只出现一次的数字
# 数组-异或运算


from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        dic = {}
        for i in nums:
            dic[i] = dic.get(i, 0) + 1
        for key, val in dic.items():
            if val == 1:
                return key
        return None

        # return reduce(lambda x, y: x ^ y, nums)


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().singleNumber(nums))
