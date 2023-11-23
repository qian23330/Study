### 力扣-1005-K次取反后最大化的数组和 ###
# 贪心


from typing import List


class Solution:
    def largestSumAfterKNegations(self, A: List[int], K: int) -> int:
        A.sort(key=lambda x: abs(x), reverse=True)  # 第一步：按照绝对值降序排序数组A

        for i in range(len(A)):  # 第二步：执行K次取反操作
            if A[i] < 0 < K:
                A[i] *= -1
                K -= 1

        if K % 2 == 1:  # 第三步：如果K还有剩余次数，将绝对值最小的元素取反
            A[-1] *= -1

        result = sum(A)  # 第四步：计算数组A的元素和
        return result


if __name__ == '__main__':
    A = list(map(int, input().split()))
    K = int(input())
    print(Solution().largestSumAfterKNegations(A, K))
