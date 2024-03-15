### 力扣-0350-两个数组的交集2 ###
# 哈希表


class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        d1, d2 = {}, {}
        for n in nums1:
            d1[n] = d1.get(n, 0) + 1
        for n in nums2:
            d2[n] = d2.get(n, 0) + 1

        ans = []
        for key in d1:
            if key in d2:
                times = min(d1[key], d2[key])
                for _ in range(times):
                    ans.append(key)
        return ans


if __name__ == '__main__':
    input_str1 = input()
    input_str2 = input()
    nums1 = list(map(int, input_str1.split()))
    nums2 = list(map(int, input_str2.split()))

    print(Solution().intersect(nums1, nums2))

# class Solution(object):
#     def intersect(self, nums1, nums2):
#         """
#         :type nums1: List[int]
#         :type nums2: List[int]
#         :rtype: List[int]
#         """
#         inter = set(nums1) & set(nums2)
#         l = []
#         for i in inter:
#             l += [i] * min(nums1.count(i), nums2.count(i))
#         return l
