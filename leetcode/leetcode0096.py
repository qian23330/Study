### 力扣-96-不同的二叉搜索树 ###
# 动态规划


class Solution:
    def numTrees(self, n: int) -> int:
        dp = [0] * (n + 1)  # 创建一个长度为n+1的数组，初始化为0
        dp[0] = 1  # 当n为0时，只有一种情况，即空树，所以dp[0] = 1
        for i in range(1, n + 1):  # 遍历从1到n的每个数字
            for j in range(1, i + 1):  # 对于每个数字i，计算以i为根节点的二叉搜索树的数量
                dp[i] += dp[j - 1] * dp[i - j]  # 利用动态规划的思想，累加左子树和右子树的组合数量
        return dp[n]  # 返回以1到n为节点的二叉搜索树的总数量


if __name__ == '__main__':
    n = int(input())
    print(Solution().numTrees(n))
