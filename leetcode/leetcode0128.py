# 力扣-128-最长连续序列
# hot100-哈希


from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)
        max_length = 0
        for num in nums_set:
            if num - 1 not in nums_set:
                new_num = num
                now_length = 1

                while new_num + 1 in nums_set:
                    new_num += 1
                    now_length += 1

                max_length = max(max_length, now_length)

        return max_length


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().longestConsecutive(nums))
