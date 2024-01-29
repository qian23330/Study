# 力扣-22-括号生成
# hot100-回溯


from typing import List


class Solution:

    def __init__(self):
        self.path = ""
        self.res = []

    def generateParenthesis(self, n: int) -> List[str]:
        self.backtrack(0, 0, n)
        return self.res

    def backtrack(self, left, right, n):
        if left > n or left < right:  # 剪枝
            return

        if len(self.path) == 2 * n:
            self.res.append(self.path)

        for i in range(2):  # 将括号看成大小为2的数组，求有效组合
            if i == 0:
                self.path += "("
                self.backtrack(left + 1, right, n)
                self.path = self.path[:-1]
            if i == 1:
                self.path += ")"
                self.backtrack(left, right + 1, n)
                self.path = self.path[:-1]


if __name__ == '__main__':
    n = int(input())
    print(Solution().generateParenthesis(n))
