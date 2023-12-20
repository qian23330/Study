### 力扣-1020-飞地的数量 ###
# bfs/dfs


from typing import List


class Solution:
    def __init__(self):
        self.position = [[-1, 0], [0, 1], [1, 0], [0, -1]]  # 四个方向

    # 深度优先遍历，把可以通向边缘部分的 1 全部标记成 true
    def dfs(self, grid: List[List[int]], row: int, col: int, visited: List[List[bool]]) -> None:
        for current in self.position:
            newRow, newCol = row + current[0], col + current[1]
            # 索引下标越界
            if newRow < 0 or newRow >= len(grid) or newCol < 0 or newCol >= len(grid[0]):
                continue
            # 当前位置值不是 1 或者已经被访问过了
            if grid[newRow][newCol] == 0 or visited[newRow][newCol]:
                continue
            visited[newRow][newCol] = True
            self.dfs(grid, newRow, newCol, visited)

    def numEnclaves(self, grid: List[List[int]]) -> int:
        rowSize, colSize, ans = len(grid), len(grid[0]), 0
        # 标记数组记录每个值为 1 的位置是否可以到达边界，可以为 True，反之为 False
        visited = [[False for _ in range(colSize)] for _ in range(rowSize)]
        # 搜索左边界和右边界，对值为 1 的位置进行深度优先遍历
        for row in range(rowSize):
            if grid[row][0] == 1:
                visited[row][0] = True
                self.dfs(grid, row, 0, visited)
            if grid[row][colSize - 1] == 1:
                visited[row][colSize - 1] = True
                self.dfs(grid, row, colSize - 1, visited)
        # 搜索上边界和下边界，对值为 1 的位置进行深度优先遍历，但是四个角不需要，因为上面遍历过了
        for col in range(1, colSize - 1):
            if grid[0][col] == 1:
                visited[0][col] = True
                self.dfs(grid, 0, col, visited)
            if grid[rowSize - 1][col] == 1:
                visited[rowSize - 1][col] = True
                self.dfs(grid, rowSize - 1, col, visited)
        # 找出矩阵中值为 1 但是没有被标记过的位置，记录答案
        for row in range(rowSize):
            for col in range(colSize):
                if grid[row][col] == 1 and not visited[row][col]:
                    ans += 1
        return ans


if __name__ == '__main__':
    grid = [[int(i) for i in num.split(',')] for num in input().split()]
    print(Solution().numEnclaves(grid))
