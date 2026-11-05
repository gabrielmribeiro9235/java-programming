package br.com.gabriel.basicsyntax;

public class Program10MultidimensionalArrays {
    public static void main(String[] args) {
        // Initialization
        int[][] matrix1 = new int[2][3];
        matrix1[0][0] = 1;
        matrix1[0][1] = 2;
        matrix1[0][2] = 3;
        matrix1[1][0] = 4;
        matrix1[1][1] = 5;
        matrix1[1][2] = 6;

        // Initialization with values
        int[][] matrix2 = {{0, 2, 4}, {6, 8, 10}};

        for(int i = 0; i < matrix1.length; i++) {
            for(int j = 0; j < matrix1[i].length; j++){
                System.out.println("Row " + i + ", Column " + j + " = " + matrix1[i][j]);
            }
        }

        System.out.println();

        for(int i = 0; i < matrix2.length; i++) {
            for(int j = 0; j < matrix2[i].length; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]: " + matrix2[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nUsing foreach:\n");

        for(int[] line : matrix1) {
            for(int num : line) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

        System.out.println();

        for(int[] line : matrix2) {
            for(int num : line) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

        System.out.println("\nPS: using \"foreach\" makes it impossible to capture the index.");
    }
}
