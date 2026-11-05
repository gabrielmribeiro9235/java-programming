package br.com.gabriel.ifsp.exercises.inheritance.figures;

public final class Triangle extends Figure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double x, double y, double a, double b, double c) {
        super(x, y);

        if (isValid(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new IllegalArgumentException("The three given sides do not form a triangle.");
        }
    }

    private static boolean isValid(double a, double b, double c) {
        return (a > 0 && b > 0 && c > 0) && (a + b > c && a + c > b && b + c > a);
    }

    @Override
    public double area() {
        double semiperimeter = (a + b + c) / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));
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
}
