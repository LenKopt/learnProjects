package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] array = new int[rows][columns];
        int number = 1;
        int lastNumber = rows * columns;
        int k = 0;

        while (number <= lastNumber) {
            for (int j = 0 + k; j < columns - k; j++) {
                array[k][j] = number;
                number++;
            }
            if (number>lastNumber){break;}
            for (int i = k + 1; i < rows - k; i++) {
                array[i][columns - k - 1] = number;
                number++;
            }
            for (int i = columns - k - 2; i >= k; i--) {
                array[rows - k - 1][i] = number;
                number++;
            }
            for (int i = rows - k - 2; i > k; i--) {
                array[i][k] = number;
                number++;
            }
            k++;
        }
        return array;
    }
}
