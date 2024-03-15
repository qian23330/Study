package com.leetcode.others.everyday.图.leetcode2368;

/*
力扣-2368-受限条件下可到达节点的数目
每日一题-24.03.02-图-dfs
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] isRestricted = new boolean[n];
        for (int x : restricted) {
            isRestricted[x] = true;
        }
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            if (!isRestricted[x] && !isRestricted[y]) {  // 都不受限->连边
                g[x].add(y);
                g[y].add(x);
            }
        }
        return dfs(0, -1, g);
    }

    private int dfs(int x, int fa, List<Integer>[] g) {
        int cnt = 1;
        for (int i : g[x]) {
            if (i != fa) {
                cnt += dfs(i, x, g);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<int[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            int[] nums = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.add(nums);
        }
        int[][] edges = list.toArray(new int[0][]);
        String[] last = scanner.nextLine().split(" ");
        int[] restricted = Arrays.stream(last)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().reachableNodes(n, edges, restricted));
    }
}
