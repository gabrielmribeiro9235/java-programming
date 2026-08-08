package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class CodeOBI2015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        if (N < 1 || N > 10000) return;

        int aux = 0;
        int counter = 0;

        for (int i = 0; i < N; i++) {
            int current = scanner.nextInt();
            if (current != 0 && current != 1) continue;
            aux = (aux * 10 + current) % 1000;

            if (aux != 0 && aux % 100 == 0) {
                counter++;
                aux = 0;
            }
        }

        System.out.println(counter);
    }
}