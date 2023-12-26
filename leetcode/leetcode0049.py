### 力扣-0049-有效的字母异位词 ###
# 哈希表


from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
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
    strs = [i for i in input().split()]
    print(Solution().groupAnagrams(strs))
