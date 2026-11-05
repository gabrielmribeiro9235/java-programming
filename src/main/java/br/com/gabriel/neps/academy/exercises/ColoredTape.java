package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class ColoredTape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] squares = new int[n];

        for (int i = 0; i < n; i++) {
            squares[i] = scanner.nextInt();

            if (i != 0 && squares[i] == 0) {
                for (int j = 1; j <= i; j++) {
                    if (squares[i - j] > j || squares[i - j] == -1) {
                        squares[i - j] = Math.min(j, 9);
                    }
                }
            } else {
                for (int j = 1; j <= i; j++) {
                    if (squares[i - j] == 0 && (squares[i] > j || squares[i] == -1)) {
                        squares[i] = Math.min(j, 9);
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < squares.length; i++) {
            int square = squares[i];
            System.out.print(square + (i == squares.length - 1 ? "" : " "));
        }
    }
}
