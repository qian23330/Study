### 力扣-695-岛屿的最大面积 ###
# bfs/dfs


import collections
from typing import List


class Solution:
    # bfs
    def __init__(self):
        self.count = 0

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        # 与200.独立岛屿不同的是：此题grid列表内是int！！！

        # BFS
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        visited = [[False for i in range(n)] for j in range(m)]

        result = 0
        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == 1:
                    # 每一个新岛屿
                    self.count = 0
                    self.bfs(grid, visited, i, j)
                    result = max(result, self.count)

        return result

    def bfs(self, grid, visited, i, j):
        self.count += 1
        visited[i][j] = True

        queue = collections.deque([(i, j)])
        while queue:
            x, y = queue.popleft()
            for new_x, new_y in [(x + 1, y), (x - 1, y), (x, y - 1), (x, y + 1)]:
                if (0 <= new_x < len(grid) and 0 <= new_y < len(grid[0]) and not visited[new_x][new_y]
                        and grid[new_x][new_y] == 1):
                    visited[new_x][new_y] = True
                    self.count += 1
                    queue.append((new_x, new_y))

    # dfs
    def __init__(self):
        self.count = 0

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        # DFS
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        visited = [[False for _ in range(n)] for _ in range(m)]

        result = 0
        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == 1:
                    self.count = 0
                    self.dfs(grid, visited, i, j)
                    result = max(result, self.count)
        return result

    def dfs(self, grid, visited, x, y):
        if visited[x][y] or grid[x][y] == 0:
            return
        visited[x][y] = True
        self.count += 1
        for new_x, new_y in [(x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)]:
            if 0 <= new_x < len(grid) and 0 <= new_y < len(grid[0]):
                self.dfs(grid, visited, new_x, new_y)


if __name__ == '__main__':
    grid = [[int(i) for i in num.split(',')] for num in input().split()]
    print(Solution().maxAreaOfIsland(grid))
