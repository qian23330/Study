### 力扣-0454-四数相加2 ###
# 哈希表

from typing import List


class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        # 使用字典存储nums1和nums2中的元素及其和
        hashmap = {}
        for n1 in nums1:
            for n2 in nums2:
                hashmap[n1 + n2] = hashmap.get(n1 + n2, 0) + 1

        # 如果 -(n1+n2) 存在于nums3和nums4, 存入结果
        count = 0
        for n3 in nums3:
            for n4 in nums4:
                key = - n3 - n4
                if key in hashmap:
                    count += hashmap[key]
        return count


if __name__ == '__main__':
    input_str1 = input()
    input_str2 = input()
    input_str3 = input()
    input_str4 = input()
    nums1 = list(map(int, input_str1.split()))
    nums2 = list(map(int, input_str2.split()))
    nums3 = list(map(int, input_str3.split()))
    nums4 = list(map(int, input_str4.split()))
    print(Solution().fourSumCount(nums1, nums2, nums3, nums4))


# from collections import defaultdict
# class Solution:
#     def fourSumCount(self, nums1: list, nums2: list, nums3: list, nums4: list) -> int:
#         rec, cnt = defaultdict(lambda : 0), 0
#         for i in nums1:
#             for j in nums2:
#                 rec[i+j] += 1
#         for i in nums3:
#             for j in nums4:
#                 cnt += rec.get(-(i+j), 0)
#         return cnt
