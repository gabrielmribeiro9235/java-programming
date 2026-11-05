package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class FailApprovedOrFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double N1 = scanner.nextDouble();
        double N2 = scanner.nextDouble();

        if ((N1 * 2 + N2 * 3) / 5 < 3) {
            System.out.println("Reprovado");
        } else if ((N1 * 2 + N2 * 3) / 5 < 7) {
            System.out.println("Final");
        } else {
            System.out.println("Aprovado");
        }
    }
}
