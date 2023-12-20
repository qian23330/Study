### 力扣-283-移动零 ###
# 数组-双指针

class Solution:
    def moveZeroes(self, nums: list[int]):  # -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        fast = 0
        slow = 0
        size = len(nums)

        while fast < size:
            if nums[fast] != 0:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1

        while slow < size:
            nums[slow] = 0
            slow += 1

        return nums


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]

    num = Solution().moveZeroes(nums)
    print(num)
