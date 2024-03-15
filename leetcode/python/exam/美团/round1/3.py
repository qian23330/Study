### 美团笔试-春招/实习 24-03-09 ###

# 小美的平衡矩阵
# 小美拿到了一个n*n 的矩阵，其中每个元素是 0 或者 1。
# 小美认为一个矩形区域是完美的，当且仅当该区域内 0 的数量恰好等于 1 的数量。
# 现在，小美希望你回答有多少个i*i的完美矩形区域。你需要回答1<=i<=n的所有答案。
#
# 输入描述
# 第一行输入一个正整数n，代表矩阵大小。
# 接下来的n行，每行输入一个长度为n的01 串，用来表示矩阵。
#
# 输出描述
# 输出n行，第i行输出的I*I 完美矩形区域的数量。


# 二维前缀和 #
n = int(input())
matrix = []
for _ in range(n):
    matrix.append([int(x) for x in input()])

pre = [[0] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, n + 1):
        pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + matrix[i - 1][j - 1]


# 查询子矩阵的和 [x1,y1] [x2,y2]表示子矩阵的左上和右下两个顶点
def getsubMatrix(x1, y1, x2, y2):
    return pre[x2 + 1][y2 + 1] - pre[x1][y2 + 1] - pre[x2 + 1][y1] + pre[x1][y1]


res = [0] * n
for i in range(n):
    for j in range(n):
        for k in range(n):
            if i + k >= n or j + k >= n:
                break
            subMatrix = getsubMatrix(i, j, i + k, j + k)
            if subMatrix * 2 == (k + 1) ** 2:
                res[k] += 1

for a in res:
    print(a)
