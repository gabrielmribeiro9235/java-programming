package br.com.gabriel.ifsp.exercises.polymorphism.figures;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[150];

        for (int i = 0; i < figures.length; i++) {
            if (i < 50) {
                figures[i] = Circle.create(i + 1);
            } else if (i < 100) {
                figures[i] = Rectangle.create(i - 49);
            } else {
                figures[i] = Triangle.create(i - 99);
            }
        }

        double sumOfTheAreas = 0;

        for (Figure figure : figures) {
            sumOfTheAreas += figure.area();
        }

        System.out.printf(Locale.US, "The sum of the areas of the 150 figures is: %.3f\n", sumOfTheAreas);
    }
}
