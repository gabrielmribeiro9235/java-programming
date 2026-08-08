package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class BetweenTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();


        for (int i = Integer.min(a, b); i <= Integer.max(a, b) ; i++) {
            System.out.printf("%d ", i);
        }
    }
}
