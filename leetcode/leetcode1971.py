### 力扣-1971-寻找图中是否存在路径 ###
# 并查集


from typing import List


class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        p = [i for i in range(n)]
        def find(i):
            if p[i] != i:
                p[i] = find(p[i])
            return p[i]
        for u, v in edges:
            p[find(u)] = find(v)
        return find(source) == find(destination)


if __name__ == '__main__':
    n = int(input())
    edges = [[int(i) for i in num.split(',')] for num in input().split()]
    source = int(input())
    destination = int(input())
    print(Solution().validPath(n, edges, source, destination))
