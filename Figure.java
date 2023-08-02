package com.epam.rd.autotasks.figures;

abstract class Figure {

    public abstract double area();

    public abstract String pointsToString();

    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    double perimeter(double sum) {
        return sum / 2;
    }

    double squareTriangle(double a, double b, double c) {
        double halfPerimetr, square;
        halfPerimetr = perimeter(a + b + c);
        square = Math.sqrt(halfPerimetr * (halfPerimetr - a) * (halfPerimetr - b) * (halfPerimetr - c));
        return square;
    }

    public abstract Point leftmostPoint();
}
