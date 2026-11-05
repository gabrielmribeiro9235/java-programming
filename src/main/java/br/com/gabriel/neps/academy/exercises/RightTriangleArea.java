package br.com.gabriel.neps.academy.exercises;

import java.util.Scanner;

public class RightTriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        System.out.println(A * B / 2);
    }
}
