package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class MagicSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] mat = new int[n][n];

        int rowSum = 0, magicSum = 0;
        boolean isMagic = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();
                rowSum += mat[i][j];
            }
            if (i != 0 && magicSum != rowSum) {
                isMagic = false;
            } else if (i == 0) {
                magicSum = rowSum;
            }
            rowSum = 0;
        }

        if (!isMagic) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < n; i++) {
            int columnSum = 0;
            for (int j = 0; j < n; j++) {
                columnSum += mat[j][i];
            }
            if (columnSum != magicSum) {
                System.out.println(-1);
                return;
            }
        }

        int diagonal1 = 0, diagonal2 = 0;
        for (int i = 0; i < n; i++) {
            diagonal1 += mat[i][i];
            diagonal2 += mat[i][n - i - 1];
        }

        if (diagonal1 != magicSum || diagonal2 != magicSum) {
            System.out.println(-1);
            return;
        }

        System.out.println(magicSum);
    }
}
