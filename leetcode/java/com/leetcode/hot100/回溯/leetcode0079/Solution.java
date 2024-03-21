package com.leetcode.hot100.回溯.leetcode0079;

/*
力扣-79-单词搜索
hot100-回溯
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtracking(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = backtracking(board, word, i + 1, j, k + 1) || backtracking(board, word, i - 1, j, k + 1) ||
                backtracking(board, word, i, j + 1, k + 1) || backtracking(board, word, i, j - 1, k + 1);
        board[i][j] = word.charAt(k);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<char[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            char[] chars = line.replace(" ", "").toCharArray();
            list.add(chars);
        }
        char[][] board = list.toArray(new char[0][]);
        String word = scanner.nextLine();
        System.out.println(new Solution().exist(board, word));
    }
}
