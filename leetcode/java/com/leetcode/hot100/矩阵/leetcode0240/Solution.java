package com.leetcode.hot100.矩阵.leetcode0240;

/*
力扣-240-搜索二维矩阵 II / 74-搜索二维矩阵
hot100-矩阵-二叉搜索树
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else return true;
        }
        return false;
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
        int target = scanner.nextInt();
        System.out.println(new Solution().searchMatrix(matrix, target));
    }
}
