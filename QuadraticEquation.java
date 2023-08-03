package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double disc = getDisc(a, b, c);
        if (disc > 0) {
            double root1 = (-b - Math.sqrt(disc)) / (2 * a);
            double root2 = (-b + Math.sqrt(disc)) / (2 * a);
            System.out.println(root1 + " " + root2);
        } else if (disc == 0) {
            double root = (-b) / (2 * a);
            System.out.println(root);
        } else {
            System.out.println("no roots");
        };
    }
    public static double getDisc(double a, double b, double c) {
        double disc;
        return disc = b * b - 4 * a * c;

    }

}