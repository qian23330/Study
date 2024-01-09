# 力扣-17-电话号码的字母组合
# 回溯


class Solution:
    def __init__(self):
        self.letterMap = [
            "",  # 0
            "",  # 1
            "abc",  # 2
            "def",  # 3
            "ghi",  # 4
            "jkl",  # 5
            "mno",  # 6
            "pqrs",  # 7
            "tuv",  # 8
            "wxyz"  # 9
        ]
        self.result = []
        self.s = ""

    def backtracking(self, digits, index):
        if index == len(digits):
            self.result.append(self.s)
            return
        digit = int(digits[index])  # 将索引处的数字转换为整数
        letters = self.letterMap[digit]  # 获取对应的字符集
        for i in range(len(letters)):
            self.s += letters[i]  # 处理字符
            self.backtracking(digits, index + 1)  # 递归调用，注意索引加1，处理下一个数字
            self.s = self.s[:-1]  # 回溯，删除最后添加的字符

    def letterCombinations(self, digits):
        if len(digits) == 0:
            return self.result
        self.backtracking(digits, 0)
        return self.result


if __name__ == '__main__':
    d = input()
    print(Solution().letterCombinations(d))
