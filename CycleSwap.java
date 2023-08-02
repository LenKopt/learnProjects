package com.epam.rd.autotasks;

import java.util.Arrays;


class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length > 0) {
            int[] returnArray = new int[array.length];
            int tempFirst = array[array.length - 1];
            System.arraycopy(array, 0, returnArray, 1, array.length - 1);
            returnArray[0] = tempFirst;
            System.arraycopy(returnArray, 0, array, 0, returnArray.length);
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length > 0) {
            int[] addArray = Arrays.copyOf(array, array.length);
            System.arraycopy(addArray, 0, array, shift, addArray.length - shift);
            System.arraycopy(addArray, addArray.length - shift, array, 0, shift);
        }
    }
}
