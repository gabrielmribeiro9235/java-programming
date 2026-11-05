package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Consecutives {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int biggestStreak = 0, currentStreak = 0, currentValue, lastValue = 0;
        for (int i = 0; i < N; i++) {
            currentValue = scanner.nextInt();

            if (i == 0 || lastValue != currentValue) {
                lastValue = currentValue;
                currentStreak = 1;
            } else {
                currentStreak++;
            }

            if (currentStreak > biggestStreak) biggestStreak = currentStreak;
        }

        System.out.println(biggestStreak);
    }
}
