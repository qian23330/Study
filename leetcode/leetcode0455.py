### 力扣-455-分发饼干 ###
# 贪心


class Solution: # 小饼干优先
    def findContentChildren(self, g, s):
        g.sort()  # 将孩子的贪心因子排序
        s.sort()  # 将饼干的尺寸排序
        index = 0
        for i in range(len(s)):  # 遍历饼干
            if index < len(g) and g[index] <= s[i]:  # 如果当前孩子的贪心因子小于等于当前饼干尺寸
                index += 1  # 满足一个孩子，指向下一个孩子
        return index  # 返回满足的孩子数目


if __name__ == '__main__':
    g = list(map(int, input().split()))
    s = list(map(int, input().split()))
    print(Solution().findContentChildren(g, s))
