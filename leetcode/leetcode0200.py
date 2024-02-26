# 力扣-200-岛屿数量
# hot100-bfs/dfs-图


from collections import deque
from typing import List


class Solution:
    # bfs
    def __init__(self):
        self.dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]  # 四个方向

    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        visited = [[False] * n for _ in range(m)]
        res = 0
        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == '1':
                    res += 1
                    self.bfs(grid, i, j, visited)  # Call bfs within this condition
        return res

    def bfs(self, grid, i, j, visited):
        q = deque()
        q.append((i, j))
        visited[i][j] = True  # 只要加入队列，立刻标记
        while q:
            x, y = q.popleft()
            for k in range(4):
                next_i = x + self.dirs[k][0]
                next_j = y + self.dirs[k][1]

                if next_i < 0 or next_i >= len(grid):
                    continue
                if next_j < 0 or next_j >= len(grid[0]):
                    continue
                if visited[next_i][next_j]:
                    continue
                if grid[next_i][next_j] == '0':
                    continue
                q.append((next_i, next_j))
                visited[next_i][next_j] = True  # 只要加入队列，立刻标记

    # dfs
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]
        dirs = [(-1, 0), (0, 1), (1, 0), (0, -1)]  # 四个方向
        result = 0

        def dfs(x, y):
            if visited[x][y] or grid[x][y] == '0':
                return  # 终止条件：访问过的节点 或者 遇到海水
            visited[x][y] = True
            for d in dirs:
                nextx = x + d[0]
                nexty = y + d[1]
                if nextx < 0 or nextx >= m or nexty < 0 or nexty >= n:  # 越界了，直接跳过
                    continue
                dfs(nextx, nexty)

        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == '1':
                    result += 1  # 遇到没访问过的陆地，+1
                    dfs(i, j)  # 将与其链接的陆地都标记上 true

        return result


if __name__ == '__main__':
    grid = [[i for i in num.split(',')] for num in input().split()]
    print(Solution().numIslands(grid))
