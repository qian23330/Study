### 力扣-844-比较含退格的字符串 ###
# 数组-双指针

class Solution:
    @staticmethod
    def backspaceCompare(s: str, t: str) -> bool:
        # 从后往前遍历
        i = len(s) - 1
        j = len(t) - 1
        skipS = 0
        skipT = 0

        while i >= 0 or j >= 0:
            while i >= 0:
                if s[i] == '#':
                    skipS += 1
                    i -= 1
                elif skipS > 0:
                    skipS -= 1
                    i -= 1
                else:
                    break

            while j >= 0:
                if t[j] == '#':
                    skipT += 1
                    j -= 1
                elif skipT > 0:
                    skipT -= 1
                    j -= 1
                else:
                    break

            if i >= 0 and j >= 0 and s[i] != t[j]:
                return False

            if (i >= 0) != (j >= 0):
                return False

            i -= 1
            j -= 1

        return True

# 另一种方法
# def backspaceCompare(self, s: str, t: str) -> bool:
#     def fun(s):
#         ans = ''
#         for c in s:
#             if c!= '#':
#                 ans += c
#             else:
#                 ans = ans[:-1]
#         return ans
#     return fun(s) == fun(t)


if __name__ == '__main__':
    string1, string2 = input().split()
    print(Solution.backspaceCompare(string1, string2))
