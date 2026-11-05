package br.com.gabriel.neps.academy.exercises;

import java.util.Locale;
import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char operation = scanner.nextLine().toCharArray()[0];
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        if (operation == 'M') {
            System.out.printf(Locale.US, "%.2f", num1 * num2);
        } else {
            System.out.printf(Locale.US, "%.2f", num1 / num2);
        }
    }
}
