package com.xup.offer.ch5;

public class MoreThanHalfNumber {
	public int MoreThanHalfNum_Solution(int [] array) {
		if (array == null || array.length <= 0)
			return 0;
		int count = 0;
		int keyNumber = array[0];
		for (int v : array) {
			if (count == 0) {
				keyNumber = v;
				count++;
			}
			else {
				if (v != keyNumber)
					count--;
				else
					count++;
			}
		}
		count = 0;
		for (int v : array) {
			if (v == keyNumber)
				count++;
		}
		if (count > array.length / 2)
			return keyNumber;
		else 
			return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(new MoreThanHalfNumber().MoreThanHalfNum_Solution(
				new int[]{1}));
	}

}
