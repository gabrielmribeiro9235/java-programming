package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Password2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        int input = scanner.nextInt();
        while (input != 2018) {
            input = scanner.nextInt();
            counter++;
        }

        System.out.println(counter);
    }
}
