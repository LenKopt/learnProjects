package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double billTotal = scan.nextDouble();
        int numberFriends = scan.nextInt();
        if ((numberFriends > 0) && (billTotal >= 0)) {
            System.out.println(getPartToPay(billTotal, numberFriends));
        } else if (numberFriends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            System.out.println("Bill total amount cannot be negative");
        }
    }

    public static int getPartToPay(double billTotal, int numFriends) {
        double toPay;
        toPay = Math.ceil(billTotal / numFriends);
        return (int) (toPay + toPay * 0.1);
    }
}
