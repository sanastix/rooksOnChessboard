package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] board = new int[n][n];
        in.close();

        int solutions = solveNRooks(board);
        System.out.println(solutions);

    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[row][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static int solveNRooks(int[][] board) {
        int n = board.length;
        return solveNRooksUtil(board, 0, n);
    }

    public static int solveNRooksUtil(int[][] board, int row, int n) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                count += solveNRooksUtil(board, row + 1, n);
                board[row][col] = 0;
            }
        }

        return count;
    }

}