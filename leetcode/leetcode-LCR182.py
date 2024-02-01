# 力扣-LCR182-动态口令
# 字符串



class Solution:
    def dynamicPassword(self, password: str, target: int) -> str:
        return password[target:] + password[:target]

    def dynamicPassword(self, password: str, target: int) -> str:
        password = list(password)
        password[0:target] = list(reversed(password[0:target]))
        password[target:] = list(reversed(password[target:]))
        password.reverse()
        return "".join(password)

    def dynamicPassword(self, password: str, target: int) -> str:
        s_list = list(password)

        self.reverse(s_list, 0, target - 1)
        self.reverse(s_list, target, len(s_list) - 1)
        self.reverse(s_list, 0, len(s_list) - 1)

        return ''.join(s_list)

    def reverse(self, s, start, end):
        while start < end:
            s[start], s[end] = s[end], s[start]
            start += 1
            end -= 1

    def dynamicPassword(self, password: str, target: int) -> str:
        new_s = ''
        for i in range(len(password)):
            j = (i + target) % len(password)
            new_s = new_s + password[j]
        return new_s

    def dynamicPassword(self, password: str, target: int) -> str:
        l = len(password)
        # 复制输入字符串与它自己连接
        s = password + password

        # 计算旋转字符串的起始索引
        k = target % (l * 2)

        # 从连接的字符串中提取旋转后的字符串并返回
        return s[k: k + l]


if __name__ == '__main__':
    psw = input()
    t = int(input())
    print(Solution().dynamicPassword(psw, t))
