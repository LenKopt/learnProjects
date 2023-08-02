package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int newNumber;
        String str = "";
        int sum=0;
        int count=0;
        do {
            newNumber = scanner.nextInt();
            str = str + newNumber+" ";
        } while (newNumber != 0);
        String[] words = str.split(" ");
        for (String item:words){

            int intItem = Integer.parseInt(item);
            if (intItem==0){
                continue;
            }

            sum += intItem;
            count++;
        }
        System.out.println((int) (sum / count));
    }

}