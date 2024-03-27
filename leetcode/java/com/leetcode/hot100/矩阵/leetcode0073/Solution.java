package com.leetcode.hot100.矩阵.leetcode0073;

/*
力扣-73-矩阵置零
hot100-矩阵-哈希
 */

import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            int[] array = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.add(array);
        }
        int[][] matrix = list.toArray(new int[0][]);
        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
