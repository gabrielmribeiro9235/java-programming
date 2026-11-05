package br.com.gabriel.ifsp.exercises.inheritance.figures;

public abstract class Figure {
    private final double x;
    private final double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
