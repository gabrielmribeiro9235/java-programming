package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class Quadrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        if (X == 0 || Y == 0) {
            System.out.println("eixos");
        } else if (X > 0 && Y > 0) {
            System.out.println("Q1");
        } else if (X < 0 && Y > 0) {
            System.out.println("Q2");
        } else if (X < 0) {
            System.out.println("Q3");
        } else {
            System.out.println("Q4");
        }
    }
}