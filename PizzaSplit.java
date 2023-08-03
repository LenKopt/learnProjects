package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numPerson = scan.nextInt();
        int numParts = scan.nextInt();
        int count = 1;
        while (checkTask(numPerson,numParts,count)){
            count++;
        }
        System.out.println(count);
    }

    public static boolean checkTask(int numPerson, int numParts, int count) {
        return (numParts * count) % numPerson != 0;
    }
}
