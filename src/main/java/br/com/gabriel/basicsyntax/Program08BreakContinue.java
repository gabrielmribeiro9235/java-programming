package br.com.gabriel.basicsyntax;

public class Program08BreakContinue {
    public static void main(String[] args) {
        int i = 0;

        while(true) {
            i++;
            if(i % 4 == 0) {
                System.out.println("Continue");
                continue;
            }
            if(i == 19) {
                System.out.println("Break at 19");
                break;
            }
            System.out.println("Iteration number " + i);
        }
    }
}
