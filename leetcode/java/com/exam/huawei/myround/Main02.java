package com.exam.huawei.myround;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
好友推荐系统
你正在为一个社交网络平台开发好友推荐功能。
平台上有N个用户(每个用户使用1到N的整数编号)，同时系统中维护了用户之间的好友关系。
为了推荐新朋友，平台决定采用“共同好友数量"作为衡量两个用户之间相似度的标准。
系统根据输入用户编号K，输出与此用户K相似度最高的前L个用户ID来推荐给用户K。
相似度定义:两个用户非好友，两个用户的相似度为拥有的共同好友数(例如用户A和用户B，只有共同好友C和D，相似度=2)

解答要求
时间限制:C/C++1000ms,其他语言:2000ms内存限制: C/C++256MB,其他语言:512MB

输入
第一行包含四个整数 N，M 、K和L，分别表示用户的数量(N)，好友记录条数(M)、查询的用户编号(K)和推荐的好友数量(L)。接下来 M 行，每行包含两个整数编号X和Y，表示编号为X和Y用户是好友。
1.输入格式都是标准的，无需考虑输出异常场景(不会包含用户和自己是好友的输入，例如11)
2.用户数不超过1024，用户编码最大1024
3.好友记录数不超过10240

输出
根据输入K和L，输出和用户K相似度最高的L个用户编码。
1.输出相似度最高的前L个用户编码，按照相似度从高到低排序
2.如果有相似度相同的可能好友，按照用户编号从小到大排序
3.如果推荐的好友个效不足L个，则推荐与用户K无无共同好友关系的用户(陌生人)作为可能好友，如果推荐仍不满足L个用户，剩余推荐用户编码使用0来占位

样例1
输入
6 7 3 2
1 2
1 3
2 3
3 4
3 5
4 5
5 6
输出
6 0
 */
public class Main02 {
    static final int N = 1024;
    static int n, m, k, l;
    static long[] num = new long[N];
    static boolean[][] f = new boolean[N][N];
    static List<Integer>[] v = new List[N];
    static List<Integer> t = new ArrayList<>();

    public static int cmp(int x, int y) {
        if (num[x] == num[y]) {
            return Integer.compare(x, y);
        }
        return Long.compare(y, x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        l = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            v[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            f[x][y] = f[y][x] = true;
            v[x].add(y);
            v[y].add(x);
        }
        for (Integer y : v[k]) {
            for (Integer z : v[y]) {
                if (k == z) {
                    continue;
                }
                if (f[k][z]) {
                    continue;
                }
                num[z]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (k != i && !f[k][i]) {
                t.add(i);
            }
        }
        while (t.size() < l) {
            t.add(0);
        }
        t.sort((x, y) -> cmp(x, y));
        for (int i = 0; i < l; i++) {
            System.out.print(t.get(i));
            if (i < l - 1) {
                System.out.print(" ");
            }
        }
    }
}
