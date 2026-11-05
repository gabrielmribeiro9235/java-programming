package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Waiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int brokenGlasses = 0;

        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int cans = scanner.nextInt();
            int glasses = scanner.nextInt();

            if (cans > glasses) brokenGlasses += glasses;
        }

        System.out.println(brokenGlasses);
    }
}
