package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Overflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        String expression = scanner.nextLine();

        expression = expression.replace(" ", "");

        String[] numbers = expression.split("[*+]");
        int P = Integer.parseInt(numbers[0]);
        int Q = Integer.parseInt(numbers[1]);

        if (expression.equals(numbers[0] + "*" + numbers[1])) {
            System.out.println(P * Q <= N ? "OK" : "OVERFLOW");
        } else {
            System.out.println(P + Q <= N ? "OK" : "OVERFLOW");
        }
    }
}
