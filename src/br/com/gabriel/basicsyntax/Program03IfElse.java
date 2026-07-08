package br.com.gabriel.basicsyntax;

import java.util.Random;

public class Program03IfElse {
    public static void main(String[] args) {
        Random generator = new Random();

        int number = generator.nextInt(3) + 1;

        String semaphore = number == 1 ? "green" : number == 2 ? "red" : "yellow";

        if(semaphore.equals("green")) {
            System.out.println("You can pass");
        } else if(semaphore.equals("red")) {
            System.out.println("Stop");
        } else {
            System.out.println("You can pass, but be careful");
        }
    }
}
