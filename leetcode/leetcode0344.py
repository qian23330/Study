### 力扣-0344-反转字符串 ###
# 双指针/栈/字符串处理/列表推导

from typing import List


class Solution:
    # 双指针
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        left, right = 0, len(s) - 1

        # 该方法已经不需要判断奇偶数，经测试后时间空间复杂度比用 for i in range(len(s)//2)更低
        # 因为while每次循环需要进行条件判断，而range函数不需要，直接生成数字，因此时间复杂度更低。推荐使用range
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1

        # return s

    # # 栈
    # def reverseString(self, s: List[str]) -> None:
    #     """
    #     Do not return anything, modify s in-place instead.
    #     """
    #     stack = []
    #     for char in s:
    #         stack.append(char)
    #     for i in range(len(s)):
    #         s[i] = stack.pop()
    #
    # # 使用range
    # def reverseString(self, s: List[str]) -> None:
    #     """
    #     Do not return anything, modify s in-place instead.
    #     """
    #     n = len(s)
    #     for i in range(n // 2):
    #         s[i], s[n - i - 1] = s[n - i - 1], s[i]
    #
    # # 使用reversed
    # def reverseString(self, s: List[str]) -> None:
    #     """
    #     Do not return anything, modify s in-place instead.
    #     """
    #     s[:] = reversed(s)
    #
    # # 使用切片
    # def reverseString(self, s: List[str]) -> None:
    #     """
    #     Do not return anything, modify s in-place instead.
    #     """
    #     s[:] = s[::-1]
    #
    # # 使用列表推导
    # def reverseString(self, s: List[str]) -> None:
    #     """
    #     Do not return anything, modify s in-place instead.
    #     """
    #     s[:] = [s[i] for i in range(len(s) - 1, -1, -1)]


if __name__ == '__main__':
    input_str = input()
    strs = list(input_str.split())
    print(Solution().reverseString(strs))
