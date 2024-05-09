package com.leetcode.hot100.回溯.leetcode0051;

/*
力扣-51-N 皇后
hot100-回溯
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = '.';
            }
        }
        backtracking(n, 0, chessboard);
        return res;
    }

    private void backtracking(int n, int row, char[][] chessboard) {
        if (row == n) {
            for (char[] c : chessboard) {
                path.add(String.copyValueOf(c));
            }
            res.add(new ArrayList<>(path));
            path.clear();
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, chessboard)) {
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] chessboard) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }

        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessboard.length; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new Solution().solveNQueens(n));
    }
}
