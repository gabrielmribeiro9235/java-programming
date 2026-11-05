package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class EntranceExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        char[] template = scanner.nextLine().trim().toCharArray();
        char[] answers = scanner.nextLine().trim().toCharArray();

        int counter = 0;
        for (int i = 0; i < N; i++) {
            counter += (template[i] == answers[i]) ? 1 : 0;
        }

        System.out.println(counter);
    }
}
