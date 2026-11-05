package br.com.gabriel.basicsyntax;

public class Program07DoWhile {
    public static void main(String[] args) {
        int i = 0;

        do {
            System.out.println("Iteration number " + ++i + " inside the Do-While statement");
        } while(i < 10);
    }
}
