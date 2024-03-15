# 力扣-LCR069-山脉数组的峰顶索引
# 二分查找


from typing import List


class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        left, right = 0, len(arr) - 2
        result = -1
        while left <= right:
            mid = (left + right) >> 1
            if arr[mid] > arr[mid + 1]:
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        return result


if __name__ == '__main__':
    arr = [int(i) for i in input().split()]
    print(Solution().peakIndexInMountainArray(arr))
