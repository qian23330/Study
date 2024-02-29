package com.leetcode.hot100.leetcode0056;

/*
力扣-56-合并区间
hot100-贪心
 */

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return res.toArray(new int[0][]);
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (res.get(res.size() - 1)[1] >= intervals[i][0]) {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据，多行输入，以空格分隔：");
        List<int[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            String[] input = line.split(" ");
            int[] nums = Arrays.stream(input)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.add(nums);
        }
        int[][] intervals = list.toArray(new int[0][]);
        System.out.println(Arrays.deepToString(new Solution().merge(intervals)));
    }
}
