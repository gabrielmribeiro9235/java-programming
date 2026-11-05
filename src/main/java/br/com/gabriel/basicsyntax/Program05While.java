package br.com.gabriel.basicsyntax;

public class Program05While {
    public static void main(String[] args) {
        int i = 0;

        while(i < 10) {
            System.out.println("Iteration number " + ++i + " inside the While statement");
        }
    }
}
