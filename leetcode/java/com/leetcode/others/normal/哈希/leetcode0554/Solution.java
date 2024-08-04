package com.leetcode.others.normal.哈希.leetcode0554;

/*
力扣-554-砖墙
normal-哈希
 */

import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, sum = 0; i < n; i++, sum = 0) {
            for (Integer cur : wall.get(i)) {
                sum += cur;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            map.remove(sum);
        }
        int res = n;
        for (Integer i : map.keySet()) {
            int cnt = map.get(i);
            res = Math.min(res, n - cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> wall = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.isEmpty()) break;
            int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> list = Arrays.stream(nums).boxed().toList();
            wall.add(list);
        }
        System.out.println(new Solution().leastBricks(wall));
    }
}
