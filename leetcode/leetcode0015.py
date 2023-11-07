### 力扣-0015-三数之和 ###
# 哈希表/双指针

from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()

        for i in range(len(nums)):
            # 如果第一个元素已经大于0，不需要进一步检查
            if nums[i] > 0:
                return result

            # 跳过相同的元素以避免重复
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            left = i + 1
            right = len(nums) - 1

            while right > left:
                sum = nums[i] + nums[left] + nums[right]

                if sum < 0:
                    left += 1
                elif sum > 0:
                    right -= 1
                else:
                    result.append([nums[i], nums[left], nums[right]])

                    # 跳过相同的元素以避免重复
                    while right > left and nums[right] == nums[right - 1]:
                        right -= 1
                    while right > left and nums[left] == nums[left + 1]:
                        left += 1

                    right -= 1
                    left += 1

        return result

    # 字典
    # def threeSum(self, nums: List[int]) -> List[List[int]]:
    #     result = []
    #     nums.sort()
    #     # 找出a + b + c = 0
    #     # a = nums[i], b = nums[j], c = -(a + b)
    #     for i in range(len(nums)):
    #         # 排序之后如果第一个元素已经大于零，那么不可能凑成三元组
    #         if nums[i] > 0:
    #             break
    #         if i > 0 and nums[i] == nums[i - 1]:  # 三元组元素a去重
    #             continue
    #         d = {}
    #         for j in range(i + 1, len(nums)):
    #             if j > i + 2 and nums[j] == nums[j - 1] == nums[j - 2]:  # 三元组元素b去重
    #                 continue
    #             c = 0 - (nums[i] + nums[j])
    #             if c in d:
    #                 result.append([nums[i], nums[j], c])
    #                 d.pop(c)  # 三元组元素c去重
    #             else:
    #                 d[nums[j]] = j
    #     return result


if __name__ == '__main__':
    input_str = input()
    nums = list(map(int, input_str.split()))
    print(Solution().threeSum(nums))


