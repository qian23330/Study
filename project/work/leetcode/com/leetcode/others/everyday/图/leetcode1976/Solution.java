package com.leetcode.others.everyday.图.leetcode1976;

/*
力扣-1976-到达目的地的方案数
每日一题-24.03.05-图-Dijkstra 算法
*/

import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        List<int[]>[] e = new ArrayList[n];
        Arrays.setAll(e, i -> new ArrayList<int[]>());
        for (int[] road : roads) {
            int x = road[0], y = road[1], t = road[2];
            e[x].add(new int[]{y, t});
            e[y].add(new int[]{x, t});
        }
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        int[] ways = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});
        dis[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] arr = pq.poll();
            long t = arr[0];
            int u = (int) arr[1];
            if (t > dis[u]) {
                continue;
            }
            for (int[] next : e[u]) {
                int v = next[0], w = next[1];
                if (t + w < dis[v]) {
                    dis[v] = t + w;
                    ways[v] = ways[u];
                    pq.offer(new long[]{t + w, v});
                } else if (t + w == dis[v]) {
                    ways[v] = (ways[u] + ways[v]) % mod;
                }
            }
        }
        return ways[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<int[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            int[] array = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.add(array);
        }
        int[][] roads = list.toArray(new int[0][]);
        System.out.println(new Solution().countPaths(n, roads));
    }
}
