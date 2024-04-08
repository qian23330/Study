### 美团笔试-春招/实习 24-03-23 ###

# 小美的元素交换
# 小美拿到了一个排列，其中初始所有元素都是红色，但有一些元素被染成了白色。
# 小美每次操作可以选择交换任意两个红色元素的位置。她希望操作尽可能少的次数使得数组变成非降序，你能帮帮她吗？
# 排列是指：一个长度为n的数组，其中 1 到n每个元素恰好出现了一次。
# 输入描述
# 第一行输入一个正整数n，代表数组的长度。
# 第二行输入n个正整数ai，代表数组的元素。
# 第三行输入一个长度为n的字符串，代表数组元素的染色情况。第i个字符为'R'代表第i个元素被染成红色，为'W'代表初始的白色。
# 1<=n<=10^5
# 1<=ai<=n
# 输出描述
# 如果无法完成排序，请输出 -1。否则输出一个整数，代表操作的最小次数。


from math import inf


n = int(input())
nums = [int(i) for i in input().split()]
colors = [c for c in input()]
dic = {}
for i, num in enumerate(nums):
    dic[num] = i

res = 0
for i, num in enumerate(nums):
    if num == i + 1:
        continue
    if colors[i] == colors[dic[i + 1]] == 'R':
        res += 1
        nums[i], nums[dic[i + 1]] = nums[dic[i + 1]], nums[i]
        dic[num] = dic[i + 1]
    else:
        res = inf

if res == inf:
    print(-1)
else:
    print(res)