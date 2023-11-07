### 力扣-0202-快乐数 ###
# 哈希表


class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n != 1:
            n = sum(int(i) ** 2 for i in str(n))
            if n in seen:
                return False
            seen.add(n)
        return True


if __name__ == '__main__':
    n = int(input())
    print(Solution().isHappy(n))
