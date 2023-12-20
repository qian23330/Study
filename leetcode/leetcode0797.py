### 力扣-797-所有可能的路径 ###
# dfs


from typing import List


class Solution:
    def __init__(self):
        self.result = []
        self.path = [0]

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        if not graph:
            return []

        self.dfs(graph, 0)
        return self.result

    def dfs(self, graph, root: int):
        if root == len(graph) - 1:  # 成功找到一条路径时
            # ***Python的list是mutable类型***
            # ***回溯中必须使用Deep Copy***
            self.result.append(self.path[:])
            return

        for node in graph[root]:  # 遍历节点n的所有后序节点
            self.path.append(node)
            self.dfs(graph, node)
            self.path.pop()  # 回溯


if __name__ == '__main__':
    graph = [[int(i) for i in num.split(',')] if num != 'na' else [] for num in input().split()]
    print(Solution().allPathsSourceTarget(graph))
