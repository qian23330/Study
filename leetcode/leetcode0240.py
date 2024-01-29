# 力扣-240-搜索二维矩阵 II
# hot100-数组-矩阵-贪心（二叉搜索树）


from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        i, j = len(matrix) - 1, 0
        while i >= 0 and j < len(matrix[0]):
            if matrix[i][j] > target:
                i -= 1
            elif matrix[i][j] < target:
                j += 1
            else:
                return True
        return False


if __name__ == '__main__':
    matrix = [[int(i) for i in num.split(",")] for num in input().split()]
    target = int(input())
    print(Solution().searchMatrix(matrix, target))
