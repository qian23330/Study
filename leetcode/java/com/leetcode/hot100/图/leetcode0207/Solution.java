package com.leetcode.hot100.图.leetcode0207;

/*
力扣-207-课程表
hot100-图-拓扑排序-bfs
 */

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return true;
        int[] indegree = new int[numCourses];
        List<Integer>[] g = new List[numCourses];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            g[pre].add(cur);
            indegree[cur]++;
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int pre = q.poll();
            numCourses--;
            for (Integer cur : g[pre]) {
                if (--indegree[cur] == 0) {
                    q.offer(cur);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCourses = scanner.nextInt();
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
        int[][] prerequisites = list.toArray(new int[0][]);
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}
