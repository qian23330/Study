package com.leetcode.others.normal.矩阵.leetcode0695;

/*
力扣-695-岛屿的最大面积
normal-bfs/dfs-矩阵
 */

import java.util.*;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    res = Math.max(count, res);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int count = 1;
        grid[i][j] = 0;
        return count
                + dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j - 1)
                + dfs(grid, i, j + 1);
    }

    private int bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                grid[i][j] = 0;
                count++;
                queue.offer(new int[]{i - 1, j});
                queue.offer(new int[]{i + 1, j});
                queue.offer(new int[]{i, j - 1});
                queue.offer(new int[]{i, j + 1});
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            int[] nums = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.add(nums);
        }
        int[][] grid = list.toArray(new int[0][]);
        System.out.println(new Solution().maxAreaOfIsland(grid));
    }
}
