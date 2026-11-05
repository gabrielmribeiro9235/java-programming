package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int c = scanner.nextInt();

        if ((l + c) % 2 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
