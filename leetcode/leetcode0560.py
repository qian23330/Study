# 力扣-560-和为K的子数组
# hot100-数组+哈希


from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dic = {}
        count, pre = 0, 0
        dic[0] = 1
        for i in range(len(nums)):
            pre += nums[i]
            if pre - k in dic:
                count += dic[pre - k]
            dic[pre] = dic.get(pre, 0) + 1
        return count


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    k = int(input())
    print(Solution().subarraySum(nums, k))
