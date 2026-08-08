package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class SimpleSearchInArray01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

        for (int number : array) {
            if (number == x) {
                System.out.println("SIM");
                return;
            }
        }
        System.out.println("NAO");
    }
}
