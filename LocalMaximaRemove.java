package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        int[] resultArray = new int[array.length];
        int i = 0;

        for (int j = 0; j < array.length; j++) {

            if ((j != 0) && (j != array.length - 1)) {
                if ((array[j + 1] >= array[j]) || (array[j - 1] >= array[j])) {
                    resultArray[i] = array[j];
                    i++;
                }
            } else if ((j == 0) && (array[0] <= array[1])) {
                resultArray[i] = array[0];
                i++;
            } else if ((j == array.length - 1) && (array[array.length - 1] <= array[array.length - 2])) {
                resultArray[i] = array[j];
                i++;
            }

        }
        int[] returnArray = Arrays.copyOf(resultArray, i);
        return returnArray;
    }
}
