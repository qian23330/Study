### 力扣-54-螺旋矩阵 ###
# 数组-模拟过程


class Solution:
    @staticmethod
    def spiralOrder(matrix: list[list[int]]) -> list[int]:
        if not matrix: return []
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

    @staticmethod
    def get_user_input():
        rows = int(input("Enter the number of rows: "))
        # cols = int(input("Enter the number of columns: "))
        matrix = []
        for _ in range(rows):
            row = list(map(int, input("Enter a row of space-separated integers: ").split()))
            matrix.append(row)
        return matrix


if __name__ == '__main__':
    matrics = Solution.get_user_input()
    print(Solution.spiralOrder(matrics))