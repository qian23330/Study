### 力扣-48-旋转图像 ###
# 数组-矩阵


from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        for i in range(n // 2):
            for j in range((n + 1) // 2):
                tmp = matrix[i][j]
                # matrix[i][j] ← matrix[n−1−j][i] ← matrix[n−1−i][n−1−j] ← matrix[j][n−1−i] ← tmp
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = tmp


if __name__ == '__main__':
    matrix = [[int(i) for i in num.split(",")] for num in input().split()]
    print(Solution().rotate(matrix))
