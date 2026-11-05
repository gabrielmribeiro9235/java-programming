package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class MinutesToHoursAndMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();

        System.out.println(m / 60);
        System.out.println(m % 60);
    }
}
