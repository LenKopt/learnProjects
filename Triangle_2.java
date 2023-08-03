package com.epam.rd.autotasks.triangle;

class Triangle {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {

        double lengthFirst = length(a, b);
        double lengthSecond = length(b, c);
        double lengthThird = length(c, a);

        if ((lengthFirst >= (lengthSecond + lengthThird)) ||
                (lengthSecond >= (lengthFirst + lengthThird)) ||
                (lengthThird >= (lengthFirst + lengthSecond))) {
            throw new IllegalArgumentException("It is not a triangle!!!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double length(Point start, Point finish) {

        double xStart = start.getX();
        double yStart = start.getY();
        double xFinish = finish.getX();
        double yFinish = finish.getY();

        return Math.sqrt((xFinish - xStart) * (xFinish - xStart) + (yFinish - yStart) * (yFinish - yStart));
    }

    public double area() {

        double a = length(this.a, this.b);
        double b = length(this.b,this.c);
        double c = length(this.c,this.a);

        double p = (a + b + c) / 2;
        double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return square;
    }

    public Point centroid() {
        double x, y;
        x = (this.a.getX() + this.b.getX() + this.c.getX()) / 3;
        y = (this.a.getY() + this.b.getY() + this.c.getY()) / 3;
        return new Point(x, y);
    }

}
