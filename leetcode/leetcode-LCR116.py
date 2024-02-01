# 力扣-LCR116-省份数量
# 图-dfs/bfs


from typing import List


class Solution:
    # dfs
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def dfs(i: int):
            for j in range(cities):
                if isConnected[i][j] == 1 and j not in visited:
                    visited.add(j)
                    dfs(j)

        cities = len(isConnected)
        visited = set()
        provinces = 0

        for i in range(cities):
            if i not in visited:
                dfs(i)
                provinces += 1

        return provinces

        # bfs
        # def findCircleNum(self, isConnected: List[List[int]]) -> int:
        #     cities = len(isConnected)
        #     visited = set()
        #     provinces = 0
        #
        #     for i in range(cities):
        #         if i not in visited:
        #             Q = collections.deque([i])
        #             while Q:
        #                 j = Q.popleft()
        #                 visited.add(j)
        #                 for k in range(cities):
        #                     if isConnected[j][k] == 1 and k not in visited:
        #                         Q.append(k)
        #             provinces += 1
        #
        #     return provinces


if __name__ == '__main__':
    isConnected = [[int(i) for i in nums.split(",")] for nums in input().split()]
    print(Solution().findCircleNum(isConnected))
