package com.leetcode.others.everyday.栈与队列.leetcode2617;

/*
力扣-2671-网格图中最少访问的格子数
每日一题-24.03.22-贪心-最小堆
*/

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int f = 0;
        PriorityQueue<int[]>[] colHeaps = new PriorityQueue[n]; // 每一列的最小堆
        Arrays.setAll(colHeaps, i -> new PriorityQueue<int[]>((a, b) -> a[0] - b[0]));
        PriorityQueue<int[]> rowH = new PriorityQueue<>((a, b) -> a[0] - b[0]); // 行最小堆
        for (int i = 0; i < m; i++) {
            rowH.clear();
            for (int j = 0; j < n; j++) {
                while (!rowH.isEmpty() && rowH.peek()[1] < j) { // 无法到达第 j 列
                    rowH.poll(); // 弹出无用数据
                }
                PriorityQueue<int[]> colH = colHeaps[j];
                while (!colH.isEmpty() && colH.peek()[1] < i) { // 无法到达第 i 行
                    colH.poll(); // 弹出无用数据
                }

                f = i > 0 || j > 0 ? Integer.MAX_VALUE : 1; // 起点算 1 个格子
                if (!rowH.isEmpty()) {
                    f = rowH.peek()[0] + 1; // 从左边跳过来
                }
                if (!colH.isEmpty()) {
                    f = Math.min(f, colH.peek()[0] + 1); // 从上边跳过来
                }

                int g = grid[i][j];
                if (g > 0 && f < Integer.MAX_VALUE) {
                    rowH.offer(new int[]{f, g + j}); // 经过的格子数，向右最远能到达的列号
                    colH.offer(new int[]{f, g + i}); // 经过的格子数，向下最远能到达的行号
                }
            }
        }
        return f < Integer.MAX_VALUE ? f : -1; // 此时的 f 是在 (m-1, n-1) 处算出来的
    }
}
