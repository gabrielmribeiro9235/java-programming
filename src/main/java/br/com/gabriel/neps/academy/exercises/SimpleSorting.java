package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class SimpleSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length - 1; i++) {
            int swap = 0;
            for (int j = 0; j < array.length - 1- i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = 1;
                }
            }
            if (swap == 0) break;
        }

        for (int number : array) {
            System.out.printf("%d ", number);
        }
    }
}
