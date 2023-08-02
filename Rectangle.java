package com.epam.rd.qa.classes;

import java.util.Objects;

public class Rectangle {
    private double sideA, sideB;

    public Rectangle(double sideA, double sideB) {
        if ((sideA <= 0)||(sideB <= 0)) {
            throw new IllegalArgumentException("Length of sides less or equal to zero!");
        }
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(double side) {

        if (side <= 0) {
            throw new IllegalArgumentException("Length of sides less or equal to zero!");
        }
        this.sideA = side;
        this.sideB = side;
    }

    public Rectangle() {
        this.sideA = 4;
        this.sideB = 3;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area() {
        return sideA * sideB;
    }

    public double perimeter() {
        return 2 * sideA + 2 * sideB;
    }

    public boolean isSquare() {
        if (sideA == sideB) {
            return true;
        } else {
            return false;
        }
    }

    public void replaceSides() {
        double temp;
        temp = sideB;
        sideB = sideA;
        sideA = temp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Rectangle r = (Rectangle) obj;

        return r.sideA == sideA && r.sideB == sideB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB);
    }

    @Override
    public String toString() {
        return "Side A = " + sideA + ", side B = " + sideB;
    }
}
