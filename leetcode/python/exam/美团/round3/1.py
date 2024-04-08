### 美团笔试-春招/实习 24-03-23 ###

# 小美的01矩阵
# 小美拿到了一个n行m列的矩阵，她想知道该矩阵有多少个 2*2 的子矩形满足 1 和 0 的数量相等？
# 输入描述
# 第一行输入两个正整数n,m用空格隔开。
# 接下来的n行，每行输入一个长度为m的 01 串，用来表示矩阵。
# 2<=n,m<=100
# 输出描述
# 一个整数，代表 1 和 0 的数量相等的 2*2 的子矩形数量。


n, m = map(int, input().split())
matrix = []
for _ in range(n):
    matrix.append([int(i) for i in input().split()])

res = 0
for i in range(n - 1):
    for j in range(m - 1):
        if matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1] == 2:
            res += 1

print(res)
