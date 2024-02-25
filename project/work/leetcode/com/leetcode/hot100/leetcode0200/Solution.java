package com.leetcode.hot100.leetcode0200;

/*
力扣-200-岛屿数量
hot100-bfs/dfs-图
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    // dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                queue.offer(new int[]{i - 1, j});
                queue.offer(new int[]{i + 1, j});
                queue.offer(new int[]{i, j - 1});
                queue.offer(new int[]{i, j + 1});
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j > grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        System.out.println("请输入一组数据，以空格分隔行，以逗号分隔列：");
        Scanner scanner = new Scanner(System.in);
        String[] inputLines = scanner.nextLine().split(" ");
        char[][] grid = new char[inputLines.length][];
        for (int i = 0; i < inputLines.length; i++) {
            grid[i] = inputLines[i].replace(",", "").toCharArray();
        }
        System.out.println(new Solution().numIslands(grid));
    }

}
