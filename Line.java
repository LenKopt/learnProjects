package com.epam.rd.autotasks.figures;

public class Line {
    private Point a, b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public double lengthLine() {
        double doubleX, doubleY;
        doubleX = (a.getX() - b.getX()) * (a.getX() - b.getX());
        doubleY = (a.getY() - b.getY()) * (a.getY() - b.getY());
        double lenghtLine = Math.sqrt(doubleX + doubleY);
        return (lenghtLine);
    }
}
