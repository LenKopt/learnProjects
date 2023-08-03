package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if (n > 0) {
            Scanner sc = new Scanner(System.in);
            String[] myArray = new String[n];
            for (int i = 0; i < n; i++) {
                myArray[i] = sc.nextLine();
            }
            for (String arr : myArray) {
                System.out.println("Hello, " + arr);
            }

        } else if (n == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else {
            System.out.println("Seriously? Why so negative?");
        }
    }


}
