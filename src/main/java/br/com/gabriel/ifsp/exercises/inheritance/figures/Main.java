package br.com.gabriel.ifsp.exercises.inheritance.figures;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
         Triangle triangle = new Triangle(0, 0, 5, 12, 13);
         Rectangle rectangle = new Rectangle(0, 0, 10, 5);
         Circle circle = new Circle(0, 0 , 10);

        System.out.printf(Locale.US, "The area of a triangle with sides %.1f, %.1f and %.1f is %.1f\n", triangle.getA(), triangle.getB(), triangle.getC(), triangle.area());
        System.out.printf(Locale.US, "The area of a circle with radius %.1f is %.1f\n", circle.getRadius(), circle.area());
        System.out.printf(Locale.US, "The area of a rectangle with width %.1f and length %.1f is %.1f\n", rectangle.getWidth(), rectangle.getLength(), rectangle.area());
    }
}
