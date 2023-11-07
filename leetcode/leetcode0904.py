### 力扣-904-水果成篮 ###
# 数组-滑动窗口

class Solution:
    @staticmethod
    def totalFruit(fruits: list[int]) -> int:
        n = len(fruits)
        ans = 0
        fruit_map = {}
        left = 0

        for right in range(n):
            fruit = fruits[right]
            if fruit in fruit_map:
                fruit_map[fruit] += 1
            else:
                fruit_map[fruit] = 1

            while len(fruit_map) > 2:
                left_fruit = fruits[left]
                fruit_map[left_fruit] -= 1
                if fruit_map[left_fruit] == 0:
                    del fruit_map[left_fruit]
                left += 1

            ans = max(ans, right - left + 1)

        return ans


if __name__ == '__main__':
    ff = []

    for i in input().split():
        ff.append(int(i))

    print(Solution.totalFruit(ff))
