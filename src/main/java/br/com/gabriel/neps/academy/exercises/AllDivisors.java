package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class AllDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) System.out.print(i + (i == N ? "" : " "));
        }
    }
}
