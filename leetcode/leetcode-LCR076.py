# 力扣-LCR076-数组中的第 K 个最大元素
# 堆


from typing import List
import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        queue = [nums[i] for i in range(k)]
        heapq.heapify(queue)

        for i in range(k, len(nums)):
            if nums[i] > queue[0]:
                heapq.heappop(queue)
                heapq.heappush(queue, nums[i])
        return queue[0]


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    k = int(input())
    print(Solution().findKthLargest(nums, k))
