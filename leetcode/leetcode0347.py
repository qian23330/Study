# 力扣-347-前 K 个高频元素
# 优先队列/堆


import heapq
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # 要统计元素出现频率
        map = {}  # nums[i]:对应出现的次数
        for i in range(len(nums)):
            map[nums[i]] = map.get(nums[i], 0) + 1

        # 对频率排序
        # 定义一个小顶堆，大小为k
        q = []  # 小顶堆

        # 用固定大小为k的小顶堆，扫描所有频率的数值
        for key, freq in map.items():
            heapq.heappush(q, (freq, key))
            if len(q) > k:  # 如果堆的大小大于了K，则队列弹出，保证堆的大小一直为k
                heapq.heappop(q)

        # 找出前K个高频元素，因为小顶堆先弹出的是最小的，所以倒序来输出到数组
        result = [0] * k
        for i in range(k - 1, -1, -1):
            result[i] = heapq.heappop(q)[1]
        return result


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    k = int(input())
    print(Solution().topKFrequent(nums, k))
