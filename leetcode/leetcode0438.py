# 力扣-438-找到字符串中所有字母异位词
# hot100-哈希表+滑动窗口

from collections import defaultdict


class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        # 初始化目标字符串与滑动窗口的哈希表，字符做键，字符个数做值
        need, window = defaultdict(int), defaultdict(int)
        # 将给定字符串的属性赋值到已经初始化好的哈希表中
        for c in p:
            need[c] += 1
        # 初始化快慢指针，覆盖程度与返回值
        left, right = 0, 0
        valid = 0
        res = []

        # 判断是否还需要进行窗口滑动
        while right < len(s):
            c = s[right]  # c是要加进窗口的字符
            right += 1  # 扩大窗口
            # 进行窗口内一系列数据的更新
            if c in need:
                window[c] += 1
                if window[c] == need[c]:
                    valid += 1
            # 判断左侧窗口是否需要收缩（窗口的长度大于给定p的长度）
            while right - left >= len(p):
                #  当窗口符合条件时，将起始索引加入res
                if valid == len(need):
                    res.append(left)
                d = s[left]  # d是将移出窗口的字符
                left += 1  # 增大左指针进行窗口收缩
                # 进行窗口内一系列数据的更新
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1

        return res


if __name__ == '__main__':
    s, p = input().split()
    print(Solution().findAnagrams(s, p))

