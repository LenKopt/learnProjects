package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Quadrilateral extends Figure {
    private Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        if ((a == null) || (b == null) || (c == null) || (d == null)) {
            throw new IllegalArgumentException("This is not Quadrilateral!");
        }

        Triangle[] array = {new Triangle(a, b, c),
                new Triangle(a, c, d)};/*,
                new Triangle(b, c, d),
                new Triangle(b, d, a)};*/

        double area = 0;
        for (Triangle nextTriangle : array) {
            area = area + nextTriangle.area();
        }

        if (area == 0) {
            throw new IllegalArgumentException("Quadrilateral is degenerate!");
        }

        double ax = a.getX(), ay = a.getY(), bx = b.getX(), by = b.getY(), cx = c.getX(), cy = c.getY(), dx = d.getX(), dy = d.getY();
        double t1 = ((dx - ax) * (by - ay) - (dy - ay) * (bx - ax));
        double t2 = ((dx - bx) * (cy - by) - (dy - by) * (cx - bx));
        double t3 = ((dx - cx) * (ay - cy) - (dy - cy) * (ax - cx));
        double t4 = ((ax - cx) * (by - cy) - (ay - cy) * (bx - cx));

        double points[][] = {{ax, ay}, {bx, by},
                {cx, cy}, {dx, dy}};
        if (!(isConvex(points))) {
            throw new IllegalArgumentException("Quadrilateral is not convex!");
        }

        if (intersectPoint(a, d, b, c) != null) {
            throw new IllegalArgumentException("Quadrilateral is self-intersecting!");
        }
    }

    static double CrossProduct(double A[][]) {
        double X1 = (A[1][0] - A[0][0]);
        double Y1 = (A[1][1] - A[0][1]);
        double X2 = (A[2][0] - A[0][0]);
        double Y2 = (A[2][1] - A[0][1]);

        return (X1 * Y2 - Y1 * X2);
    }

    static boolean isConvex(double points[][]) {
        int N = points.length;

        double prev = 0;

        double curr = 0;

        for (int i = 0; i < N; i++) {

            double temp[][] = {points[i],
                    points[(i + 1) % N],
                    points[(i + 2) % N]};

            curr = CrossProduct(temp);

            if (curr != 0) {

                if (curr * prev < 0) {
                    return false;
                } else {
                    prev = curr;
                }
            }
        }
        return true;
    }

    private Point intersectPoint(Point start1, Point end1, Point start2, Point end2) {
        double x1 = start1.getX();
        double y1 = start1.getY();
        double x2 = end1.getX();
        double y2 = end1.getY();

        double x3 = start2.getX();
        double y3 = start2.getY();
        double x4 = end2.getX();
        double y4 = end2.getY();

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double x = x1 + t * (x2 - x1);
        double y = y1 + t * (y2 - y1);
        if (0.0 <= t && t <= 1.0 && 0.0 <= u && u <= 1.0) {
            return new Point(x, y);
        }
        return null;

    }

    static double[] find_Centroid(double v[][]) {
        double[] ans = new double[2];

        int n = v.length;
        double signedArea = 0;

        // For all vertices
        for (int i = 0; i < n; i++) {

            double x0 = v[i][0], y0 = v[i][1];
            double x1 = v[(i + 1) % n][0], y1 = v[(i + 1) % n][1];

            // Calculate value of A
            // using shoelace formula
            double A = (x0 * y1) - (x1 * y0);
            signedArea += A;

            // Calculating coordinates of
            // centroid of polygon
            ans[0] += (x0 + x1) * A;
            ans[1] += (y0 + y1) * A;
        }

        signedArea *= 0.5;
        ans[0] = (ans[0]) / (6 * signedArea);
        ans[1] = (ans[1]) / (6 * signedArea);

        return ans;
    }

    @Override
    public Point centroid() {

        double vp[][] = {{a.getX(), a.getY()},
                {b.getX(), b.getY()},
                {c.getX(), c.getY()},
                {d.getX(), d.getY()}};

        double[] ans = find_Centroid(vp);
        return new Point(ans[0], ans[1]);
    }

    double[] createAray(Quadrilateral obj, int n) {
        double[] array = new double[4];
        if (n == 1) {
            array[0] = obj.a.getX();
            array[1] = obj.b.getX();
            array[2] = obj.c.getX();
            array[3] = obj.d.getX();
        } else {
            array[0] = obj.a.getY();
            array[1] = obj.b.getY();
            array[2] = obj.c.getY();
            array[3] = obj.d.getY();
        }
        Arrays.sort(array);
        return array;
    }

    @Override
    public boolean isTheSame(Figure figure) {

        double delta = 0.000001;
        double[] xThis = createAray(this, 1);
        double[] yThis = createAray(this, 2);
        double[] xFigure = createAray((Quadrilateral) figure, 1);
        double[] yFigure = createAray((Quadrilateral) figure, 2);
        for (int i = 0; i < 4; i++) {
            if ((Math.abs(xThis[i] - xFigure[i]) >= delta) || (Math.abs(yThis[i] - yFigure[i]) >= delta)) {
                return false;
            }
        }

        return true;
    }
}
