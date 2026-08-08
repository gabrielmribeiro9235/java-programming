package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Roots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.printf("%.4f\n", Math.sqrt(scanner.nextDouble()));
        }
    }
}
