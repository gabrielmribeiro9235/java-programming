package br.com.gabriel.ifsp.exercises.polymorphism.figures;

import java.util.Objects;

public class Circle implements Figure {
    private final double radius;

    private Circle(double radius) {
        if (isRadiusValid(radius)) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Invalid radius value");
        }
    }

    private static boolean isRadiusValid(double radius) {
        return radius > 0;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + getRadius() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(getRadius(), circle.getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getRadius());
    }

    @Override
    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public static Circle create(double value) {
        return new Circle(value);
    }
}
