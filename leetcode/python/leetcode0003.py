# 力扣-3-无重复字符的最长子串
# hot100-滑动窗口


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dic, res, i = {}, 0, -1
        for j in range(len(s)):
            if s[j] in dic:
                i = max(dic[s[j]], i)  # 更新左指针i
            dic[s[j]] = j  # 哈希表记录
            res = max(res, j - i)  # 更新结果
        return res


if __name__ == '__main__':
    s = input()
    print(Solution().lengthOfLongestSubstring(s))
