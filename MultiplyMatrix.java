package com.epam.rd.autotasks.matrices;

import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];

        int n = matrix1.length;
        int m = matrix2.length;
        int k = matrix2[0].length;

        for (int i = 0; i < n; i++) {
            for (int u = 0; u < k; u++) {
                for (int j = 0; j < m; j++) {
                    resultMatrix[i][u] += matrix1[i][j] * matrix2[j][u];
                }
            }
        }

        return resultMatrix;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567}};

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6}};

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
