package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner scan = new Scanner(System.in);
        int newNumber;
        String str = "";
        do{
            newNumber = scan.nextInt();
            str = str + newNumber+" ";
        }while (newNumber!=0);
        String[] array = str.split(" ");
        int max=Integer.parseInt(array[0]);

        for (String item:array){
            int intItem = Integer.parseInt(item);
            if (intItem==0){
                continue;
            }
            if (intItem>max){
                max = intItem;
            }
        }
        return max;

    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        System.out.println(max());
    }
}
