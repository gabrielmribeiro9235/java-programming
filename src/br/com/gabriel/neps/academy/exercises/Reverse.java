package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputs = new int[10];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = scanner.nextInt();
        }

        for (int i = inputs.length-1; i >= 0; i--) {
            System.out.println(inputs[i]);
        }
    }
}
