### 华为笔试-实习 24-04-10 ###

# 3.网络保卫战
#
# 公有云的某个region内，N个网络节点组网情况可以使用一个n* n的矩阵matrix表示，在这个组网图中，matrix[i][j] = p 时，
# 表示用户在编号为 i的节点访问编号为j的节点时，必须在 i节点上具有>=p 的权限等级(p=0时表示无法通过第i节点访问j节点)，
# 如果用户成功访问了j节点，那么它在j节点上的权限等级调整为 P。
# exposed 为一个整数数组，表示暴露在公网上的网络节点的编号列表。某天扫描发现这批暴需在公网的节点存在被外部恶意攻击风险且该攻击会影响到可访问的其他节点，
# 并可以持续传递进行攻击，被恶意攻击的节点从公网访问时，攻击者获得了ROOT 权限(权限等级为10，即最大值)。
# 小李是一名网络安全工程师，为了在有限的时间内尽可能的减少故障带来的损失，需要立即将某个节点从公网"下线"。
# 假设攻击结束时，被攻击过的节点数量为R，请帮小李计算出将哪个节点下线能使R尽可能小，如果答案有多个节点，返回索引最小的那个节点。
# 请注意：从公网“下线”的节点，不会受到来自公网的攻击，但仍然可能被“可访问”的其他节点传递攻击。
#
# 解答要求
# 时间限制: C/C++ 5000ms,其他语言: 10000ms内存限制: C/C++ 128MB，其他语言: 256MB
#
# 输入的第一行是网络节点数量N
# 后续的N行，每行N个数字v，以空格分割，形成一个N*N的矩阵，表示网络节点组网的矩阵。
# 最后一行，输入 exposed 数组，表示暴露在公网上的网络节点的编号列表，数组元素不会重复。
# 输入范围说明：
# 2<=n<=24
# 0<=v<=10
# 0<=exposed[i]<=n-1
#
# 输出
# 输出在 exposed 数组中，计划"下线”的那个节点的编号。


N = 30
a = [[0] * N for _ in range(N)]
st = [False] * N
n = 0


def dfs(id, ra):
    num = 0
    for i in range(n):
        if id == i or not a[id][i]:
            continue
        if ra >= a[id][i]:
            if st[i]:
                continue
            st[i] = True
            num += dfs(i, a[id][i])
            st[i] = False
    return num + 1


def main():
    global n
    n = int(input())
    for i in range(n):
        a[i] = list(map(int, input().split()))

    res = -1
    ans = 0
    nodes = list(map(int, input().split()))
    for x in nodes:
        for i in range(n):
            if x == i:
                continue
            st[x] = True
            t = dfs(x, 10)
            st[x] = False
            if t > ans:
                ans = t
                res = x
    print(res)


if __name__ == "__main__":
    main()