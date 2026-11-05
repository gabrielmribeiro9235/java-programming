package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Minefield {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] output = new int[N];
        for (int i = 0; i < N; i++) {
            int current = scanner.nextInt();
            if (current == 1) {
                if (i != 0) {
                    output[i - 1]++;
                }
                if (i != N -1) {
                    output[i + 1]++;
                }
                output[i]++;
            }
        }

        for (int number : output) {
            System.out.println(number);
        }
    }
}
