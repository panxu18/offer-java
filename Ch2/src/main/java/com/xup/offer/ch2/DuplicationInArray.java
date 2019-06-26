package com.xup.offer.ch2;

public class DuplicationInArray {
	
	public int duplicate(int[] array) {
		/* 
		 * 空数组检查
		 */
		if (array.length <= 0 ) {
			return -1;
		}
		/*
		 * 数组元素范围检查
		 */
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0 || array[i] > array.length-1)
				throw new IllegalArgumentException();
		}
		/*
		 * 主要业务部分
		 */
		int[] ret = null;
		
		for (int i = 0; i < array.length; i++) {
			while (array[i] != i) {
				int t = array[i];
				if (array[t] == t)
					return t;
				array[i] = array[t];
				array[t] = t;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] array = null;
		array = new int[]{2, 3, 1, 0, 2, 5, 3};
		
		
	}

}
