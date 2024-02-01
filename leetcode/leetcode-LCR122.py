# 力扣-LCR122-路径加密
# 字符串


class Solution:
    def pathEncryption(self, path: str) -> str:
        res = []
        for i in range(len(path)):
            if path[i] == '.':
                res.append(' ')
            else:
                res.append(path[i])
        return ''.join(res)

    def replaceSpace(self, s: str) -> str:
        n = len(s)
        for e, i in enumerate(s[::-1]):
            print(i, e)
            if i == ".":
                s = s[: n - (e + 1)] + " " + s[n - e:]
            print("")
        return s

    def replaceSpace(self, s: str) -> str:
        return " ".join(s.split("."))

    def replaceSpace(self, s: str) -> str:
        return s.replace('.', ' ')


if __name__ == '__main__':
    strs = input()
    print(Solution().pathEncryption(strs))
