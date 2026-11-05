package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class SimplePower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        System.out.printf("%.4f", Math.pow(x, y));
    }
}
