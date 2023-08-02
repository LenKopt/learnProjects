package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        Line sideA, sideB, sideC;
        double lenghtA, lenghtB, lenghtC;
        sideA = new Line(a, b);
        sideB = new Line(b, c);
        sideC = new Line(c, a);
        lenghtA = sideA.lengthLine();
        lenghtB = sideB.lengthLine();
        lenghtC = sideC.lengthLine();

        double square = squareTriangle(lenghtA, lenghtB, lenghtC);

        return square;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point leftPoint;
        if (a.getX() < b.getX()) {
            leftPoint = a;
        } else {
            leftPoint = b;
        }
        if (c.getX() < leftPoint.getX()) {
            return c;
        } else {
            return leftPoint;
        }
    }

    @Override
    public String pointsToString() {
        String pointsA, pointsB, pointsC;
        pointsA = a.toString();
        pointsB = b.toString();
        pointsC = c.toString();
        return pointsA + pointsB + pointsC;
    }
}
