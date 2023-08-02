package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private Point a;
    private double radius;

    public Circle(Point a, double radius) {
        this.a = a;
        this.radius = radius;
        if (a == null) {
            throw new IllegalArgumentException("This is not circle!");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("This circle don't exist!");
        }
    }

    @Override
    public Point centroid() {
        return a;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        //Math.abs(a-b) < delta
        final double delta = 0.0000000001;

        if (this.getClass() == figure.getClass()) {
            Point centerFigure = ((Circle) figure).a;
            boolean matchX = Math.abs(a.getX() - centerFigure.getX()) < delta;
            boolean matchY = Math.abs(a.getY() - centerFigure.getY()) < delta;
            if (((Math.abs(radius - ((Circle) figure).radius) < delta)) && (matchX && matchY)) {
                return true;
            }
        }
        return false;
    }
}
