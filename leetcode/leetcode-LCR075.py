# 力扣-LCR075-数组的相对排序
# 堆


from typing import List


class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:

        def mycmp(x: int) -> (int, int):
            return (0, rank[x]) if x in rank else (1, x)

        rank = {x: i for i, x in enumerate(arr2)}
        arr1.sort(key=mycmp)
        return arr1


if __name__ == '__main__':
    arr1 = [int(i) for i in input().split()]
    arr2 = [int(i) for i in input().split()]
    print(Solution().relativeSortArray(arr1, arr2))
