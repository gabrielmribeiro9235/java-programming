package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class HowManyLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        char c = scanner.nextLine().toCharArray()[0];

        int count = 0;
        for (char sChar : s.toCharArray()) {
            if (sChar == c) count++;
        }

        System.out.println(count);
    }
}
