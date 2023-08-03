package com.epam.rd.autotasks.snail;
import java.util.Scanner;
public class Snail
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int h = scan.nextInt();
        int days = returnNumberDays(a, b, h);
        if (days != -1) {
            System.out.println(days);
        } else {
            System.out.println("Impossible");
        }

    }
    public static int returnNumberDays(int a, int b, int h) {
        int days = 0;

        if (a >= h) {
            return 1;
        } else if (b >= a) {
            return -1;
        }
        for (int i = a; i <= h; i = i - b + a) {
            days++;
        }
        return days;
    }
}
