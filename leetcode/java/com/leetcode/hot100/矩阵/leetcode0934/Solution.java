package com.leetcode.hot100.矩阵.leetcode0934;

/*
力扣-934-最短的桥
dfs bfs
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private final int[] dirs = new int[]{-1, 0, 1, 0, -1};
    private Queue<int[]> q = new LinkedList<>();
    private int[][] grid;
    private int n;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        for (int i = 0, x = 1; i < n && x == 1; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    x = 0;
                    break;
                }
            }
        }
        int res = 0;
        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (grid[x][y] == 1) {
                            return res;
                        }
                        if (grid[x][y] == 0) {
                            grid[x][y] = 2;
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
            res++;
        }
    }

    private void dfs(int i, int j) {
        grid[i][j] = 2;
        q.offer(new int[]{i, j});
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}
