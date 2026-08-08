package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int factorial = 1;
        for (int i = 0; i < N; i++) {
            factorial *= (i + 1);
        }

        System.out.println(factorial);
    }
}
