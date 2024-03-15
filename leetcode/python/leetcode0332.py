### 力扣-332-重新安排行程 ###
# 回溯


from collections import defaultdict
from typing import List


class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        targets = defaultdict(list)  # 创建默认字典，用于存储机场映射关系
        for ticket in tickets:
            targets[ticket[0]].append(ticket[1])  # 将机票输入到字典中

        for key in targets:
            targets[key].sort(reverse=True)  # 对到达机场列表进行字母逆序排序

        result = []
        self.backtracking("JFK", targets, result)  # 调用回溯函数开始搜索路径
        return result[::-1]  # 返回逆序的行程路径

    def backtracking(self, airport, targets, result):
        while targets[airport]:  # 当机场还有可到达的机场时
            next_airport = targets[airport].pop()  # 弹出下一个机场
            self.backtracking(next_airport, targets, result)  # 递归调用回溯函数进行深度优先搜索
        result.append(airport)  # 将当前机场添加到行程路径中


if __name__ == '__main__':
    tik = input().split(",")
    tickets = [pair.strip().split() for pair in tik]
    print(Solution().findItinerary(tickets))
