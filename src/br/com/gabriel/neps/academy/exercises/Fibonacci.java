package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int fib = 1, last = 0;
        for (int i = 0; i < N; i++) {
            int temp = fib;
            fib += last;
            last = temp;
        }
        System.out.println(fib);
    }
}
