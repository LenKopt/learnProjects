package com.epam.rd.autotasks.array;

public class IntArrayUtil {

	public static int maximumDistance(int[] array) {
		if ((array != null)&&(array.length>0)) {
			int max = maxArray(array);
			int first = -1, last = -1;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == max) {

					if (first == -1) {
						first = i;
					}
					last = i;
				}

			}
			return last - first;
		} else {
			return 0;
		}
	}
	public static int maxArray(int[] arr) {
		// Предположим, что нулевой элемент максимальный
		int max = arr[0];

// В цикле начинаем с первой ячейки
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}
	public static void main(String[] args) {
		{
			int[] array = null;
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] {};
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 4, 100, 3, 4 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 5, 50, 50, 4, 5 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 5, 350, 350, 4, 350 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 10, 10, 10, 10, 10 };
			System.out.println("result = " + maximumDistance(array));
		}
	}

}
