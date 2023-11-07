### 力扣-0020-删除字符串中的所有相邻重复项 ###
# 栈


class Solution:
    # 方法一，使用栈
    def removeDuplicates(self, s: str) -> str:
        res = list()
        for item in s:
            if res and res[-1] == item:
                res.pop()
            else:
                res.append(item)
        return "".join(res)  # 字符串拼接

    # 方法二，使用双指针模拟栈，如果不让用栈可以作为备选方法。
    def removeDuplicates(self, s: str) -> str:
        res = list(s)
        slow = fast = 0
        length = len(res)

        while fast < length:
            # 如果一样直接换，不一样会把后面的填在slow的位置
            res[slow] = res[fast]

            # 如果发现和前一个一样，就退一格指针
            if slow > 0 and res[slow] == res[slow - 1]:
                slow -= 1
            else:
                slow += 1
            fast += 1

        return ''.join(res[0: slow])


if __name__ == '__main__':
    strs = input()
    print(Solution().removeDuplicates(strs))
