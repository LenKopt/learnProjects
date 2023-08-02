package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        System.out.println(String.format("%01d:%02d:%02d", seconds / 3600 == 24 ? seconds / 3600 - 24 : seconds / 3600, seconds / 60 % 60, seconds % 60));
    }
}
