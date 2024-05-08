### 华为笔试-实习 24-04-10 ###

# 2.相似图片分类
#
# 小明想要处理一批图片，将相似的图片分类。他首先对图片的特征采样，得到图片之间的相似度，然后按照以下规则判断图片是否可以归为一类:
# 1)相似度>0表示两张图片相似，
# 2)如果A和B相似，B和C相似，但A和C不相似。那么认为A和C间接相似，可以把ABC归为一类，但不计算AC的相似度
# 3)如果A和所有其他图片都不相似，则A自己归为一类，相似度为0.给定一个大小为NxN的矩阵M存储任意两张图片的相似度，
# M[i][j]即为第i个图片和第j个图片的相似度，请按照"从大到小”的顺序返回每个相似类中所有图片的相似度之和。
#
# 解答要求
# 时间限制: C/C++ 1000ms,其他语言: 2000ms内存限制: C/C++ 256MB,其他语言: 512MB
#
# 输入
# 第一行一个数N，代表矩阵M中有N个图片，下面跟着N行，每行有N列数据，空格分隔(为了显示整弃，空格可能为多个) 代表N个图片之间的相似度。
#
# 输出
# 每个相似类的相似度之和。格式为:一行数字，分隔符为1个空格。


N = 900 + 7
num = [0] * N
p = [0] * N
a = [[0] * N for _ in range(N)]


def find(x):
    if x != p[x]:
        p[x] = find(p[x])
    return p[x]


n = int(input())

for i in range(n):
    p[i] = i
    num[i] = 0

for i in range(n):
    a[i] = list(map(int, input().split()))

for i in range(n):
    for j in range(i, n):
        if a[i][j] > 0:
            px, py = find(i), find(j)
            if px != py:
                p[px] = py
                num[py] += a[i][j] + num[px]
            else:
                num[py] += a[i][j]


res = [num[i] for i in range(n) if p[i] == i]
res.sort(reverse=True)
print(' '.join(map(str, res)))