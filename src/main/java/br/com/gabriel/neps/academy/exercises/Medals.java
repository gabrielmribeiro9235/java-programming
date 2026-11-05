package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Medals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] times = new int[3];
        int golden = 0, silver = 1, bronze = 2;
        for (int i = 0; i < times.length; i++) {
            times[i] = scanner.nextInt();
            if (times[golden] > times[i]) {
                bronze = silver;
                silver = golden;
                golden = i;
            } else if (times[silver] > times[i]) {
                bronze = silver;
                silver = i;
            } else {
                bronze = i;
            }
        }

        System.out.println(golden + 1);
        System.out.println(silver + 1);
        System.out.println(bronze + 1);
    }
}
