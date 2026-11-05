package br.com.gabriel.ifsp.exercises.inheritance.figures;

public final class Rectangle extends Figure {
    private final double width;
    private final double length;

    public Rectangle(double x, double y, double width, double length) {
        super(x, y);
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}
