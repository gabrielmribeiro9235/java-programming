package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class SumOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum += scanner.nextInt();
        }

        System.out.println(sum);
    }


}
