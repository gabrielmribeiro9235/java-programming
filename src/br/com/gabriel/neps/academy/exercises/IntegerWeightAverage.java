package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class IntegerWeightAverage {
    public static final int WEIGHT_A = 4;
    public static final int WEIGHT_B = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        System.out.println((A * WEIGHT_A + B * WEIGHT_B) / (WEIGHT_A + WEIGHT_B));
    }
}
