package com.leetcode.hot100.矩阵.leetcode0049;

/*
力扣-49-旋转图像
hot100-矩阵
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rows = n / 2, columns = (n + 1) / 2;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
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
        int[][] matrix = list.toArray(new int[0][]);
        new Solution().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
