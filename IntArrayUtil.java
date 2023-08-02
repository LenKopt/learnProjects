package com.epam.rd.autotasks.array;

import java.util.Arrays;

public class IntArrayUtil {

	public static void swapEven(int[] array) {
		int temp = 0;
		if (array!=null){
			int lengh_a = array.length;
			for (int i=0;i<lengh_a/2;i++){
				if ((array[i]%2==0)&&(array[lengh_a-i-1])%2==0){
					temp = array[i];
					array[i]=array[lengh_a-i-1];
					array[lengh_a-i-1]=temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		{
			int[] array = null;
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] {};
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] { 10, 5, 3, 4 };
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] { 100, 2, 3, 4, 5 };
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] { 100, 2, 3, 45, 33, 8, 4, 54 };
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
	}

}
