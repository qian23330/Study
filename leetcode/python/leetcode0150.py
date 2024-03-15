### 力扣-0150-逆波兰表达式求值 ###
# 栈


from operator import add, sub, mul
from typing import List


class Solution:
    op_map = {'+': add, '-': sub, '*': mul, '/': lambda x, y: int(x / y)}

    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token not in {'+', '-', '*', '/'}:
                stack.append(int(token))
            else:
                op2 = stack.pop()
                op1 = stack.pop()
                stack.append(self.op_map[token](op1, op2))  # 第一个出来的在运算符后面
        return stack.pop()


if __name__ == '__main__':
    ll = []
    for i in input().split():
        ll.append(i)
    print(Solution().evalRPN(ll))
