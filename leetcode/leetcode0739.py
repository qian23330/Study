### 力扣-739-每日温度 ###
# 单调栈


from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        answer = [0] * len(temperatures)
        stack = [0]
        for i in range(1, len(temperatures)):
            # 情况一和情况二
            if temperatures[i] <= temperatures[stack[-1]]:
                stack.append(i)
            # 情况三
            else:
                while len(stack) != 0 and temperatures[i] > temperatures[stack[-1]]:
                    answer[stack[-1]] = i - stack[-1]
                    stack.pop()
                stack.append(i)

        return answer


if __name__ == '__main__':
    temperatures = [int(i) for i in input().split()]
    print(Solution().dailyTemperatures(temperatures))
