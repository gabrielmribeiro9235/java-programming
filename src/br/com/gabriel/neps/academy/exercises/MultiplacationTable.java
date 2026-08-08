package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class MultiplacationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            System.out.println(X + " * " + (i + 1) + " = " + (X * (i + 1)));
        }
    }
}
