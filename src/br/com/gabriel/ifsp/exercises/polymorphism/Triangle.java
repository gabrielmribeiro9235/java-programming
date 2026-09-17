package br.com.gabriel.ifsp.exercises.polymorphism;

import java.util.Objects;

public class Triangle implements Figure {
    private final double a;
    private final double b;
    private final double c;

    private Triangle(double a, double b, double c) {
        if (isTriangleValid(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new IllegalArgumentException("The three given sides do not form a triangle.");
        }
    }

    private static boolean isTriangleValid(double a, double b, double c) {
        return  (a > 0 && b > 0 && c > 0) && (a + b > c && a + c > b && b + c > a);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + getA() +
                ", b=" + getB() +
                ", c=" + getC() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(getA(), triangle.getA()) == 0 && Double.compare(getB(), triangle.getB()) == 0 && Double.compare(getC(), triangle.getC()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB(), getC());
    }

    @Override
    public double area() {
        double semiperimeter = (a + b + c) / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));
    }

    public static Triangle create(double value) {
        return new Triangle(value, value, value);
    }
}
