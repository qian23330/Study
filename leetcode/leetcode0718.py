### 力扣-718-最长重复子数组 ###
# 动态规划


from typing import List


class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        # 创建一个二维数组 dp，用于存储最长公共子数组的长度
        dp = [[0] * (len(nums2) + 1) for _ in range(len(nums1) + 1)]
        # 记录最长公共子数组的长度
        result = 0

        # 遍历数组 nums1
        for i in range(1, len(nums1) + 1):
            # 遍历数组 nums2
            for j in range(1, len(nums2) + 1):
                # 如果 nums1[i-1] 和 nums2[j-1] 相等
                if nums1[i - 1] == nums2[j - 1]:
                    # 在当前位置上的最长公共子数组长度为前一个位置上的长度加一
                    dp[i][j] = dp[i - 1][j - 1] + 1
                # 更新最长公共子数组的长度
                if dp[i][j] > result:
                    result = dp[i][j]

        # 返回最长公共子数组的长度
        return result


if __name__ == '__main__':
    nums1 = [int(x) for x in input().split()]
    nums2 = [int(x) for x in input().split()]
    print(Solution().findLength(nums1, nums2))
    