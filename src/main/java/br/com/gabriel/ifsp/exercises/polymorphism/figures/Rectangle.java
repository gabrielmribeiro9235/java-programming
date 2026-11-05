package br.com.gabriel.ifsp.exercises.polymorphism.figures;

import java.util.Objects;

public class Rectangle implements Figure {
    private final double width;
    private final double length;

    private Rectangle(double width, double length) {
        if (isArgumentValid(width) && isArgumentValid(length)) {
            this.width = width;
            this.length = length;
        } else {
            throw new IllegalArgumentException("Invalid width and/or length value");
        }
    }

    private static boolean isArgumentValid(double arg) {
        return arg > 0;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + getWidth() +
                ", length=" + getLength() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(getWidth(), rectangle.getWidth()) == 0 && Double.compare(getLength(), rectangle.getLength()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWidth(), getLength());
    }

    @Override
    public double area() {
        return width * length;
    }

    public static Rectangle create(double value) {
        return new Rectangle(value, value);
    }
}
