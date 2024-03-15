### 力扣-435-无重叠区间 ###
# 贪心


from typing import List


class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0

        intervals.sort(key=lambda x: x[0])  # 按照左边界升序排序

        result = 1  # 不重叠区间数量，初始化为1，因为至少有一个不重叠的区间

        for i in range(1, len(intervals)):
            if intervals[i][0] >= intervals[i - 1][1]:  # 没有重叠
                result += 1
            else:  # 重叠情况
                intervals[i][1] = min(intervals[i - 1][1], intervals[i][1])  # 更新重叠区间的右边界

        return len(intervals) - result


if __name__ == '__main__':
    intervals = [[int(num) for num in member.split(',')] for member in input().split()]
    print(Solution().eraseOverlapIntervals(intervals))
