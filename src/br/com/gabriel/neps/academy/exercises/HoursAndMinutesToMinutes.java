package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class HoursAndMinutesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(h * 60 + m);
    }
}
