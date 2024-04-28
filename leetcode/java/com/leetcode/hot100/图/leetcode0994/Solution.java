package com.leetcode.hot100.图.leetcode0994;

/*
力扣-994-腐烂的橘子
hot100-bfs
*/

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int cnt = 0;  // 新鲜橘子数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int round = 0;  // 腐烂的轮数
        while (cnt > 0 && !q.isEmpty()) {
            round++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] orange = q.poll();
                int x = orange[0];
                int y = orange[1];
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    cnt--;
                    q.offer(new int[]{x - 1, y});
                }
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    cnt--;
                    q.offer(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    cnt--;
                    q.offer(new int[]{x, y - 1});
                }
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    cnt--;
                    q.offer(new int[]{x, y + 1});
                }
            }
        }
        if (cnt > 0) return -1;
        else return round;
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
        System.out.println(new Solution().orangesRotting(grid));
    }
}
