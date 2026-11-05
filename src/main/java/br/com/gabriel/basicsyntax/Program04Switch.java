package br.com.gabriel.basicsyntax;

import java.util.Random;

public class Program04Switch {
    public static void main(String[] args) {
        Random generator = new Random();

        int number = generator.nextInt(5) + 1;

        switch (number) {
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            default:
                System.out.println("FIVE");
        }
    }
}
