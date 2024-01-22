# 力扣-32-最长有效括号
# 动态规划


class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n = len(s)
        if n == 0:
            return 0
        dp = [0] * n
        res = 0
        for i in range(n):
            if i > 0 and s[i] == ")":
                if s[i - 1] == "(":
                    dp[i] = dp[i - 2] + 2
                elif s[i - 1] == ")" and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == "(":
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
                res = max(res, dp[i])
        return res


if __name__ == '__main__':
    s = input()
    print(Solution().longestValidParentheses(s))
