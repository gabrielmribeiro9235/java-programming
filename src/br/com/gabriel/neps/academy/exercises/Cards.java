package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int expectedSum = 2 * a, receivedSum = a;

        int b = scanner.nextInt();
        if (b != a) {
            expectedSum += 2 * b;
        }
        receivedSum += b;

        int c = scanner.nextInt();
        if (c != a && c != b) {
            expectedSum += 2 * c;
        }
        receivedSum += c;

        System.out.println(expectedSum - receivedSum);
    }
}
