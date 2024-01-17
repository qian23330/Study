# 力扣-215-数组中的第K个最大元素
# 优先队列/堆


from typing import List
import heapq


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # 先将前k个元素入堆
        q = [nums[i] for i in range(k)]
        heapq.heapify(q)

        for i in range(k, len(nums)):
            if nums[i] > q[0]:
                heapq.heappop(q)  # 弹出堆顶元素
                heapq.heappush(q, nums[i])  # nums[i] 入堆
        return q[0]


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    k = int(input())
    print(Solution().findKthLargest(nums, k))
