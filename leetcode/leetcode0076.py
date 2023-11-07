### 力扣-76-最小覆盖子串 ###
# 数组-滑动窗口


from collections import defaultdict


class Solution:
    @staticmethod
    def minWindow(s: str, t: str) -> str:
        minLen = len(t)
        maxLen = len(s)

        if maxLen < minLen:
            return ""

        char_count = defaultdict(int)

        for char in t:
            char_count[char] += 1

        char_list = []

        for i in range(maxLen):
            if s[i] in char_count:
                char_list.append(i)

        res = s + "a"
        left = 0
        count = 0

        for right in range(len(char_list)):
            if char_count[s[char_list[right]]] == 1:
                count += 1
            char_count[s[char_list[right]]] -= 1

            if count == len(char_count):
                while char_count[s[char_list[left]]] < 0:
                    char_count[s[char_list[left]]] += 1
                    left += 1

                substr = s[char_list[left]:char_list[right] + 1]

                if len(substr) < len(res):
                    res = substr

                if char_count[s[char_list[left]]] == 0:
                    count -= 1

                char_count[s[char_list[left]]] += 1
                left += 1

        return res if len(res) <= len(s) else ""


if __name__ == "__main__":
    s = input()
    t = input()
    print(Solution.minWindow(s, t))


