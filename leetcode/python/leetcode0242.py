### 力扣-0242-有效的字母异位词 ###
# 哈希表


class Solution:
    @staticmethod
    def isAnagram(s: str, t: str) -> bool:
        from collections import defaultdict

        s_dict = defaultdict(int)
        t_dict = defaultdict(int)
        for x in s:
            s_dict[x] += 1

        for x in t:
            t_dict[x] += 1
        return s_dict == t_dict


if __name__ == '__main__':
    s, t = input().split()
    print(Solution.isAnagram(s, t))


# class Solution(object):
#     def isAnagram(self, s: str, t: str) -> bool:
#         from collections import Counter
#         a_count = Counter(s)
#         b_count = Counter(t)
#         return a_count == b_count
