### 力扣-496-下一个更大元素 I ###
# 单调栈


from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = [-1] * len(nums1)
        stack = [0]
        for i in range(1, len(nums2)):
            # 情况一情况二
            if nums2[i] <= nums2[stack[-1]]:
                stack.append(i)
            # 情况三
            else:
                while len(stack) != 0 and nums2[i] > nums2[stack[-1]]:
                    if nums2[stack[-1]] in nums1:
                        index = nums1.index(nums2[stack[-1]])
                        result[index] = nums2[i]
                    stack.pop()
                stack.append(i)
        return result


if __name__ == '__main__':
    num1 = [int(i) for i in input().split()]
    num2 = [int(i) for i in input().split()]
    print(Solution().nextGreaterElement(num1, num2))
