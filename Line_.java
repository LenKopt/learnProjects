package com.epam.rd.autotasks.figures;

public class Line {
    private Point a, b;
    private double k;
    private double m;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
        double A = a.getY() - b.getY();
        double B = b.getX() - a.getX();
        double C = a.getX() * b.getY() - b.getX() * a.getY();
        this.k = - A / B;
        this.m = - C / B;
    }

    public Point getA() {
        return a;
    }

    public double getK() {
        return k;
    }

    public double getM() {
        return m;
    }

    public Point getB() {
        return b;
    }

    public double lengthLine() {
        double doubleX, doubleY;
        doubleX = (a.getX() - b.getX()) * (a.getX() - b.getX());
        doubleY = (a.getY() - b.getY()) * (a.getY() - b.getY());
        double lenghtLine = Math.sqrt(doubleX + doubleY);
        return (lenghtLine);
    }
}
