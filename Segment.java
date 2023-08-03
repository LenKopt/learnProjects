package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    private Point start, finish;

    public Segment(Point start, Point finish) {
        if (((start.getX() == finish.getX()) && ((start.getY() == finish.getY()))) || (start == null) || (finish == null)) {
            throw new IllegalArgumentException("the start and the end of the segment is the same point");
        }
        this.start = start;
        this.finish = finish;
    }

    public Point getStart() {
        return start;
    }

    public Point getFinish() {
        return finish;
    }

    double length() {
        if ((start == null) || (finish == null)) {
            return 0;
        }
        double xStart = start.getX();
        double yStart = start.getY();
        double xFinish = finish.getX();
        double yFinish = finish.getY();

        return Math.sqrt((xFinish - xStart) * (xFinish - xStart) + (yFinish - yStart) * (yFinish - yStart));
    }

    Point middle() {
        double xStart = start.getX();
        double yStart = start.getY();
        double xFinish = finish.getX();
        double yFinish = finish.getY();

        return new Point((xStart + xFinish) / 2, (yStart + yFinish) / 2);
    }

    Point intersection(Segment another) {
        double xStart = start.getX();
        double yStart = start.getY();
        double xFinish = finish.getX();
        double yFinish = finish.getY();

        double x3 = another.getStart().getX();
        double y3 = another.getStart().getY();
        double x4 = another.getFinish().getX();
        double y4 = another.getFinish().getY();

        Point pointIntersection = null;

        Point point = intersectionLines(xStart, xFinish, x3, x4, yStart, yFinish, y3, y4);
        if (point == null) {
            return pointIntersection;
        }
        if (conditionEquelsLenghts(this, point) && conditionEquelsLenghts(another, point)) {
            pointIntersection = point;
        }
        return pointIntersection;
    }

    public double getLength(Segment segment, Point point) {

        Segment segmentFirst = new Segment(segment.start, point);
        Segment segmentSecond = new Segment(point, segment.finish);

        double result = segmentFirst.length() + segmentSecond.length();

        return (Math.rint(result * 100)) / 100;
    }

    public boolean conditionEquelsLenghts(Segment segment, Point point) {
        boolean result = false;
        if (((segment.start.getX() == point.getX()) && (segment.start.getY() == point.getY())) ||
                ((segment.finish.getX() == point.getX()) && (segment.finish.getY() == point.getY()))) {
            result = true;
        } else {
            result = (Math.rint(segment.length() * 100) / 100 == getLength(segment, point));
        }
        return result;
    }

    public Point intersectionLines(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4) {
        Point point = null;
        if (((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4)) != 0) {
            double x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
            double y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
            return new Point(x, y);
        }
        return point;
    }

}
