# 力扣-LCR065-单词的压缩编码
# 哈希集合


from typing import List


class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        good = set(words)
        for word in words:
            for k in range(1, len(word)):
                good.discard(word[k:])

        return sum(len(word) + 1 for word in good)


if __name__ == '__main__':
    words = [i for i in input().split()]
    print(Solution().minimumLengthEncoding(words))
