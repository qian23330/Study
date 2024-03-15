package com.leetcode.hot100.矩阵.leetcode0054;

/*
力扣-54-螺旋矩阵
hot100-矩阵
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);  // 左->右
            }
            if (++top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);  // 上->下
            }
            if (--right < left) break;

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);  // 右->左
            }
            if (--bottom < top) break;

            for (int i = bottom; i >= top ; i--) {
                res.add(matrix[i][left]);  // 下->上
            }
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("请输入一组数组，每一行是一个数组，数组内的元素以空格分隔：");
        Scanner scanner = new Scanner(System.in);

        List<int[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {  // 当读到空行时，认为输入结束，跳出循环
                break;
            }
            int[] array = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.add(array);  // 添加数组到列表中
        }

        int[][] matrix = list.toArray(new int[0][]);
        System.out.println(new Solution().spiralOrder(matrix));
    }
}
