package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        int max = values[0];
        for (int item : values) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }
}
