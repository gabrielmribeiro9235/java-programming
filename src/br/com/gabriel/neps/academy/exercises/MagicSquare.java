package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class MagicSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] mat = new int[n][n];
        int[] rowSums = new int[n];
        int[] columnSums = new int[n];
        int diagonal1 = 0, diagonal2 = 0;
        int magicSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();

                rowSums[i] += mat[i][j];
                columnSums[j] += mat[i][j];

                if (i == j) {
                    diagonal1 += mat[i][j];
                }

                if (i + j + 1 == n) {
                    diagonal2 += mat[i][j];
                }
            }

            if (i == 0) magicSum = rowSums[i];
        }

        if (diagonal1 != magicSum || diagonal2 != magicSum) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (columnSums[i] != magicSum || rowSums[i] != magicSum) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(magicSum);
    }
}
