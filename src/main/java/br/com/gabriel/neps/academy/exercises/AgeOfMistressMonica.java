package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class AgeOfMistressMonica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int missingAge = M - A - B;

        System.out.println(Math.max(A, Math.max(B, missingAge)));
    }
}
