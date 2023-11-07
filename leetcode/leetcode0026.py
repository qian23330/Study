### 力扣-26-删除有序数组的重复项 ###
# 数组-双指针

class Solution:
    @staticmethod
    def removeDuplicates(nums: list[int]) -> int:
        fast = 1
        slow = 1
        size = len(nums)

        while fast < size:
            if nums[fast - 1] != nums[fast]:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow


if __name__ == '__main__':
    number = []
    for i in input().split():
        number.append(int(i))
    print(Solution.removeDuplicates(number))