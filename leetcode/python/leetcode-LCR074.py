# 力扣-LCR074-合并区间
# 数组


from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        result = []
        if len(intervals) == 0:
            return result
        intervals.sort(key=lambda x: x[0])
        result.append(intervals[0])

        for i in range(1, len(intervals)):
            if result[-1][1] >= intervals[i][0]:
                result[-1][1] = max(result[-1][1], intervals[i][1])
            else:
                result.append(intervals[i])
        return result


if __name__ == '__main__':
    intervals = [[int(i) for i in num.split(',')] for num in input().split()]
    print(Solution().merge(intervals))
