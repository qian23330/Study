# 力扣-131-分割回文串
# hot100-回溯


from typing import List


class Solution:

    def partition(self, s: str) -> List[List[str]]:
        result = []
        self.backtracking(s, 0, [], result)
        return result

    def backtracking(self, s, start_index, path, result):
        # Base Case
        if start_index == len(s):
            result.append(path[:])
            return

        # 单层递归逻辑
        for i in range(start_index, len(s)):
            # 若反序和正序相同，意味着这是回文串
            if s[start_index: i + 1] == s[start_index: i + 1][::-1]:
                path.append(s[start_index:i + 1])
                self.backtracking(s, i + 1, path, result)  # 递归纵向遍历：从下一处进行切割，判断其余是否仍为回文串
                path.pop()  # 回溯


if __name__ == '__main__':
    s = input()
    print(Solution().partition(s))
