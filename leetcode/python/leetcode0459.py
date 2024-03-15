### 力扣-0459-重复的子字符串 ###
# 字符串匹配-KMP


class Solution:
    # 前缀表-1
    def repeatedSubstringPattern(self, s: str) -> bool:
        if len(s) == 0:
            return False
        nxt = [0] * len(s)
        self.getNext(nxt, s)
        if nxt[-1] != -1 and len(s) % (len(s) - (nxt[-1] + 1)) == 0:
            return True
        return False

    def getNext(self, nxt, s):
        nxt[0] = -1
        j = -1
        for i in range(1, len(s)):
            while j >= 0 and s[i] != s[j + 1]:
                j = nxt[j]
            if s[i] == s[j + 1]:
                j += 1
            nxt[i] = j
        return nxt

    def repeatedSubstringPattern(self, s: str) -> bool:
        n = len(s)
        if n <= 1:
            return False
        ss = s[1:] + s[:-1]
        print(ss.find(s))
        return ss.find(s) != -1

    # 暴力法
    def repeatedSubstringPattern(self, s: str) -> bool:
        n = len(s)
        if n <= 1:
            return False

        substr = ""
        for i in range(1, n // 2 + 1):
            if n % i == 0:
                substr = s[:i]
                if substr * (n // i) == s:
                    return True

        return False


if __name__ == '__main__':
    strs = input()
    print(Solution().repeatedSubstringPattern(strs))
