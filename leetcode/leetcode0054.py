### 力扣-54-螺旋矩阵 ###
# 数组-模拟过程


from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []
        l, r, t, b, res = 0, len(matrix[0]) - 1, 0, len(matrix) - 1, []

        while True:
            for i in range(l, r + 1):
                res.append(matrix[t][i])  # left to right
            t += 1
            if t > b:
                break
            for i in range(t, b + 1):
                res.append(matrix[i][r])  # top to bottom
            r -= 1
            if l > r:
                break
            for i in range(r, l - 1, -1):
                res.append(matrix[b][i])  # right to left
            b -= 1
            if t > b:
                break
            for i in range(b, t - 1, -1):
                res.append(matrix[i][l])  # bottom to top
            l += 1
            if l > r:
                break
        return res


if __name__ == '__main__':
    matrix = [[int(i) for i in num.split(",")] for num in input().split()]
    print(Solution().spiralOrder(matrix))
