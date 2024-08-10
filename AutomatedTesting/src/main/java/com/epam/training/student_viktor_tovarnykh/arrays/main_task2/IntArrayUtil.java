package com.epam.training.student_viktor_tovarnykh.arrays.main_task2;

import java.util.Arrays;
import java.util.stream.Collector;

public class IntArrayUtil {

	public static int maximumDistance(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int biggestValue = Arrays.stream(array).max().getAsInt();
		int firstIndexValue = -1;
		int lastIndexValue = 0;

		for(int i = 0; i<array.length; i++){
			if (array[i] == biggestValue){
				if (firstIndexValue == -1){
					firstIndexValue = i;
				}
				lastIndexValue = i;
			}
		}

		return lastIndexValue - firstIndexValue;
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
