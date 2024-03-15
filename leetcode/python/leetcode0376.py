### 力扣-376-摆动序列 ###
# 贪心


from typing import List


class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)  # 如果数组长度为0或1，则返回数组长度
        preDiff, curDif, result = 0, 0, 1  # 题目里nums长度大于等于1，当长度为1时，其实到不了for循环里去，所以不用考虑nums长度
        for i in range(len(nums) - 1):
            curDiff = nums[i + 1] - nums[i]
            if curDiff * preDiff <= 0 and curDiff !=0:  # 差值为0时，不算摆动
                result += 1
                preDiff = curDiff  # 如果当前差值和上一个差值为一正一负时，才需要用当前差值替代上一个差值
        return result


if __name__ == '__main__':
    nums = list(map(int, input().split()))
    print(Solution().wiggleMaxLength(nums))
