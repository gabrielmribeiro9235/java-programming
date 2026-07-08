package br.com.gabriel.basicsyntax;

public class Program09Arrays {
    public static void main(String[] args) {
        // basic array initialization
        int[] myArray = new int[3];
        myArray[0] = 10;
        myArray[1] = 20;
        myArray[2] = 30;

        // basic array initialization with values
        int[] mySecondArray = {11, 22, 33};

        for(int i = 0; i < myArray.length; i++) {
            System.out.println("myArray[" + i + "] = " + myArray[i]);
        }

        System.out.println();

        for(int i = 0; i < mySecondArray.length; i++) {
            System.out.println("mySecondArray[" + i + "] = " + mySecondArray[i]);
        }

        System.out.println("\nUsing foreach:\n");

        int i = 0;
        for(int j : myArray) {
            System.out.println("myArray[" + i + "] = " + j);
            i++;
        }

        System.out.println();

        i = 0;
        for(int j : mySecondArray) {
            System.out.println("mySecondArray[" + i + "] = " + j);
            i++;
        }

        System.out.println("\nPS: using \"foreach\" makes it impossible to capture the index.");
    }
}
