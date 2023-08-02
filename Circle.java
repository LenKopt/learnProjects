package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private Point a;
    private double radious;

    public Circle(Point a, double radious) {
        this.a = a;
        this.radious = radious;
    }

    @Override
    public double area() {
        return Math.PI * radious * radious;
    }

    @Override
    public String pointsToString() {
        String pointCenter;
        pointCenter = a.toString();

        return pointCenter;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radious + "]";
    }

    @Override
    public Point leftmostPoint() {
        double leftPointX = a.getX() - radious;
        double leftPointY = a.getY();

        return new Point(leftPointX, leftPointY);
    }
}
