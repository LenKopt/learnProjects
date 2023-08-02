package com.epam.rd.autotasks.matrix;

import java.util.Arrays;

public class MatrixUtil {

	public static void transformMatrix(int[][] matrix) {
		if ((matrix != null) && (matrix.length > 0) && (checkSquareMatrix(matrix))) {

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; matrix[i].length > j; j++) {
					if (i != j) {
						if (i < j) {
							matrix[i][j] = 1;
						} else {
							matrix[i][j] = 0;
						}
					}
				}
			}
		}
	}
	public static boolean checkSquareMatrix(int[][] i) {

		int maxRow = i.length;
		boolean IsSquare = true;
		for (int j = 0; j < i.length; j++) {
			if ((maxRow < i[j].length) || (maxRow > i[j].length)) {
				IsSquare = false;
				break;
			}
		}
		return IsSquare;
	}
	public static void main(String[] args) {
		{
			int[][] matrix = null;
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = {};
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { {} };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { {}, {} };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 3 }, { 4, 5, 6 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 3 }, { 4, 5 }, {} };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 3 }, { 4, 5 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 }, { 5, 7, 8, 5 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{

			int[][] matrix = { { 2, 3 }, { 4, 5 }, { 6, 7 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}

	}

}
