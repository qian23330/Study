# 力扣-20-有效的括号
# 栈


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for item in s:
            if item == '(':
                stack.append(')')
            elif item == '[':
                stack.append(']')
            elif item == '{':
                stack.append('}')
            elif not stack or stack[-1] != item:
                return False
            else:
                stack.pop()

        return True if not stack else False


if __name__ == '__main__':
    strs = input()
    print(Solution().isValid(strs))
