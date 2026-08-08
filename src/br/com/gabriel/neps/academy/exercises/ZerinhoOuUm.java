package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class ZerinhoOuUm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        if (A == B && B == C) {
            System.out.println("*");
        } else if (A != B && A != C) {
            System.out.println("A");
        } else if (B != A) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }
    }
}
