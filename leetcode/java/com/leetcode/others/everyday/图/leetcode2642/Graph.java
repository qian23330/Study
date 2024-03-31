package com.leetcode.others.everyday.图.leetcode2642;

/*
力扣-2867-设计可以求最短路径的图类
每日一题-24.03.26-图-Dijkstra-堆优化
*/

import java.util.*;

class Graph {
    private final List<int[]>[] g; // 邻接表

    public Graph(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            addEdge(e);
        }
    }

    public void addEdge(int[] e) {
        g[e[0]].add(new int[]{e[1], e[2]});
    }

    public int shortestPath(int start, int end) {
        int[] dis = new int[g.length]; // dis[i] 表示从起点 start 出发，到节点 i 的最短路长度
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, start});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int d = p[0];
            int x = p[1];
            if (x == end) { // 计算出从起点到终点的最短路长度
                return d;
            }
            if (d > dis[x]) { // x 之前出堆过，无需更新邻居的最短路
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0];
                int w = e[1];
                if (d + w < dis[y]) {
                    dis[y] = d + w; // 更新最短路长度
                    pq.offer(new int[]{dis[y], y});
                }
            }
        }
        return -1; // 无法到达终点
    }
}
