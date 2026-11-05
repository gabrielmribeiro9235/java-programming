package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class BiggestAmongThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            int readValue = scanner.nextInt();

            if (readValue > max) max = readValue;
        }

        System.out.println(max);
    }
}
