package com.xup.offer.ch3;

import java.util.Arrays;
import java.util.function.Predicate;

public class ReorderArray {

	public void reOrderArray(int [] array) {
		Integer[] arrayList = Arrays.stream(array).boxed().toArray(Integer[]::new);
		reOrderArray(arrayList, (a)->{return a % 2 == 0;});
		int index = 0;
		for (int e : arrayList) {
			array[index++] = e;
		}
	}
	
	private <T> void reOrderArray(T[] array, Predicate<T> operator) {
		T[] tempArray = Arrays.copyOf(array, array.length);
		int index = 0;
		for (T e : tempArray) {
			if (!(operator.test(e)))
				array[index++] = e;
		}
		for (T e : tempArray) {
			if ((operator.test(e)))
				array[index++] = e;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{2,4,6,1,3,6,8,12,4,2,4,7,5};
		new ReorderArray().reOrderArray(array);
		for (int e : array) {
			System.out.println(e);
		}
	}

}
