# 力扣-LCR067-数组中两个数的最大异或值
# 异或位运算-哈希


from typing import List


class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        # 最高位的二进制位编号为 30
        HIGH_BIT = 30

        x = 0
        for k in range(HIGH_BIT, -1, -1):
            seen = set()
            # 将所有的 pre^k(a_j) 放入哈希表中
            for num in nums:
                # 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                # 只需将其右移 k 位
                seen.add(num >> k)

            # 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            # 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            x_next = x * 2 + 1
            found = False

            # 枚举 i
            for num in nums:
                if x_next ^ (num >> k) in seen:
                    found = True
                    break

            if found:
                x = x_next
            else:
                # 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                # 即为 x = x*2
                x = x_next - 1

        return x


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().findMaximumXOR(nums))
