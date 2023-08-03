package com.epam.rd.autotasks.intersection;

public class Line {
    private int k;
    private int b;
    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }
    public int getK() {
        return k;
    }

    public int getB() {
        return b;
    }

    public Point intersection(Line other) {
        int x, y;
        Point point = null;

        if (this.k != other.getK()) {
            y = (this.k * other.getB() - other.getK() * this.b) / (this.k - other.getK());
            x = (y - this.b) / this.k;
            point = new Point(x,y);
        }

        return point;
    }

}
