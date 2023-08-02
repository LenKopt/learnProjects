package com.epam.rd.autotasks.figures;

abstract class Figure{

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
    double perimeter(double sum) {
        return sum / 2;
    }

    double squareTriangle(double a, double b, double c) {
        double halfPerimetr, square;
        halfPerimetr = perimeter(a + b + c);
        square = Math.sqrt(halfPerimetr * (halfPerimetr - a) * (halfPerimetr - b) * (halfPerimetr - c));
        return square;
    }

}
