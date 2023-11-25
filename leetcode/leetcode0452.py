### 力扣-452-用最少数量的箭引爆气球 ###
# 贪心


from typing import List


class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        if len(points) == 0:
            return 0
        points.sort(key=lambda x: x[0])
        result = 1
        for i in range(1, len(points)):
            if points[i][0] > points[i - 1][1]:  # 气球i和气球i-1不挨着，注意这里不是>=
                result += 1
            else:
                points[i][1] = min(points[i - 1][1], points[i][1])  # 更新重叠气球最小右边界
        return result


if __name__ == '__main__':
    points = [[int(num) for num in member.split(',')] for member in input().split()]
    print(Solution().findMinArrowShots(points))
