package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class SumOfTheVector {
    public static int sum_vector(int n, int[] v) {
        int sum = 0;

        for (int item : v) sum += item;

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }

        System.out.println(sum_vector(n, v));
    }
}
