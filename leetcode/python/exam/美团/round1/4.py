### 美团笔试-春招/实习 24-03-09 ###

# 小美的区间删除
# 小美拿到了一个大小为n的数组，她希望删除一个区间后，使得剩余所有元素的乘积末尾至少有k个 0。
# 小美想知道，一共有多少种不同的删除方案？
#
# 输入描述
# 第一行输入两个正整数n，k。第二行输入n个正整数ai，代表小美拿到的数组。
# 1<=n,k<=10^5
# 1<=ai<=10^9

# 输出描述
# 一个整数，代表删除的方案数。
import bisect
from itertools import accumulate


n, k = map(int, input().split())
A = [int(c) for c in input().split()]


def getFactor2(a):
    f2 = 0
    while a != 0 and a % 2 == 0:
        f2 += 1
        a //= 2
    return f2


def getFactor5(a):
    f5 = 0
    while a != 0 and a % 5 == 0:
        f5 += 1
        a //= 5
    return f5


f2s, f5s = [getFactor2(a) for a in A], [getFactor5(a) for a in A]
all2, all5 = sum(f2s), sum(f5s)

pres2 = list(accumulate(f2s, initial=0))
pres5 = list(accumulate(f5s, initial=0))

cnt = 0
for i, a in enumerate(A):
    p2 = bisect.bisect_right(pres2, pres2[i] + all2 - k)
    p5 = bisect.bisect_right(pres5, pres5[i] + all5 - k)
    cnt += min(p2, p5) - i - 1
print(cnt)
