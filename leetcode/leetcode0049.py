### 力扣-0049-有效的字母异位词 ###
# 哈希表


class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        sorted_strs = ["".join(sorted(s)) for s in strs]
        anagram_dict = {}
        for i, s in enumerate(sorted_strs):
            if s not in anagram_dict:
                anagram_dict[s] = []
            anagram_dict[s].append(i)
        ans = []
        for k, v in anagram_dict.items():
            ans.append([strs[i] for i in v])
        return ans


if __name__ == '__main__':
    strs = []
    for i in input().split():
        strs.append(i)
    print(Solution().groupAnagrams(strs))