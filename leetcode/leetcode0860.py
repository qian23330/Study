### 力扣-860-柠檬水找零 ###
# 贪心


from typing import List


class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five = 0
        ten = 0
        twenty = 0

        for bill in bills:
            # 情况一：收到5美元
            if bill == 5:
                five += 1

            # 情况二：收到10美元
            if bill == 10:
                if five <= 0:
                    return False
                ten += 1
                five -= 1

            # 情况三：收到20美元
            if bill == 20:
                # 先尝试使用10美元和5美元找零
                if five > 0 and ten > 0:
                    five -= 1
                    ten -= 1
                    # twenty += 1
                # 如果无法使用10美元找零，则尝试使用三张5美元找零
                elif five >= 3:
                    five -= 3
                    # twenty += 1
                else:
                    return False

        return True


if __name__ == '__main__':
    bills = list(map(int, input().split()))
    print(Solution().lemonadeChange(bills))
