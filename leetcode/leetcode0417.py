### 力扣-417-太平洋大西洋水流问题 ###
# bfs/dfs


from typing import List


class Solution:
    def __init__(self):
        self.position = [[-1, 0], [0, 1], [1, 0], [0, -1]]  # 四个方向

    # heights：题目给定的二维数组， row：当前位置的行号， col：当前位置的列号
    # sign：记录是哪一条河，两条河中可以一个为 0，一个为 1
    # visited：记录这个位置可以到哪条河
    def dfs(self, heights: List[List[int]], row: int, col: int, sign: int, visited: List[List[List[int]]]):
        for current in self.position:
            curRow, curCol = row + current[0], col + current[1]
            # 索引下标越界
            if curRow < 0 or curRow >= len(heights) or curCol < 0 or curCol >= len(heights[0]):
                continue
            # 不满足条件或者已经被访问过
            if heights[curRow][curCol] < heights[row][col] or visited[curRow][curCol][sign]:
                continue
            visited[curRow][curCol][sign] = True
            self.dfs(heights, curRow, curCol, sign, visited)

    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rowSize, colSize = len(heights), len(heights[0])
        # visited 记录 [row, col] 位置是否可以到某条河，可以为 true，反之为 false；
        # 假设太平洋的标记为 1，大西洋为 0
        # ans 用来保存满足条件的答案
        ans, visited = [], [[[False for _ in range(2)] for _ in range(colSize)] for _ in range(rowSize)]
        for row in range(rowSize):
            visited[row][0][1] = True
            visited[row][colSize - 1][0] = True
            self.dfs(heights, row, 0, 1, visited)
            self.dfs(heights, row, colSize - 1, 0, visited)
        for col in range(0, colSize):
            visited[0][col][1] = True
            visited[rowSize - 1][col][0] = True
            self.dfs(heights, 0, col, 1, visited)
            self.dfs(heights, rowSize - 1, col, 0, visited)
        for row in range(rowSize):
            for col in range(colSize):
                # 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
                if visited[row][col][0] and visited[row][col][1]:
                    ans.append([row, col])
        return ans


if __name__ == '__main__':
    heights = [[int(i) for i in num.split(',')] for num in input().split()]
    print(Solution().pacificAtlantic(heights))
