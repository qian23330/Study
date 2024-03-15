### 力扣-0349-两个数组的交集 ###
# 哈希表


class Solution:
    def intersection(self, nums1: list[int], nums2: list[int]) -> list[int]:
        # 使用哈希表存储一个数组中的所有元素
        table = {}
        for num in nums1:
            table[num] = table.get(num, 0) + 1

        # 使用集合存储结果
        res = set()
        for num in nums2:
            if num in table:
                res.add(num)
                del table[num]

        return list(res)


if __name__ == '__main__':
    input_str1 = input()
    input_str2 = input()
    nums1 = list(map(int, input_str1.split()))
    nums2 = list(map(int, input_str2.split()))

    print(Solution().intersection(nums1, nums2))


# class Solution:
#     def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         return list(set(nums1) & set(nums2))
