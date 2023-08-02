package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if ((a == null) || (b == null) || (c == null)) {
            throw new IllegalArgumentException("This is not triangle!");
        }
        Line sA, sB, sC;
        sA = new Line(a, b);
        sB = new Line(b, c);
        sC = new Line(c, a);

        double area = area();

        if (area == 0) {
            throw new IllegalArgumentException("Triangle is degenerate!");
        }


    }
    public double area() {
        return Math.abs(0.5*((c.getX() - a.getX()) * (b.getY() - a.getY()) -
                (c.getY() - a.getY()) * (b.getX() - a.getX())));
    }
    @Override
    public Point centroid() {
        double X, Y;
        X = (a.getX() + b.getX() + c.getX()) / 3;
        Y = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(X, Y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this.getClass()==figure.getClass()){

        }
        return false;
    }
}
