package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        Line sideA, sideB, sideC, sideD;
        double lenghtA, lenghtB, lenghtC, lenghtD;
        sideA = new Line(a, b);
        sideB = new Line(b, c);
        sideC = new Line(c, d);
        sideD = new Line(d, a);

        lenghtA = sideA.lengthLine();
        lenghtB = sideB.lengthLine();
        lenghtC = sideC.lengthLine();
        lenghtD = sideD.lengthLine();

        double lenghtDiagonal = new Line(a, c).lengthLine();
        double squareFirst = squareTriangle(lenghtA, lenghtB, lenghtDiagonal);
        double squareSecond = squareTriangle(lenghtC, lenghtD, lenghtDiagonal);
        return squareFirst + squareSecond;
    }

    @Override
    public String pointsToString() {
        String pointsA, pointsB, pointsC, pointsD;
        pointsA = a.toString();
        pointsB = b.toString();
        pointsC = c.toString();
        pointsD = d.toString();
        return pointsA + pointsB + pointsC + pointsD;
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
            leftPoint = c;
        }
        if (d.getX() < leftPoint.getX()) {
            return d;

        } else {
            return leftPoint;
        }
    }
}
