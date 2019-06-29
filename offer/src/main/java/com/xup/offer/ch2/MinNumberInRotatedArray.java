package com.xup.offer.ch2;

public class MinNumberInRotatedArray {
	
	public int minNumberInRotateArray(int [] array) {
		if (array == null || array.length == 0)
			return 0;
		for (int i = 0; i < array.length-1; i++) {
			if (array[i] < 0)
				throw new IllegalArgumentException();
			if (array[i+1] < array[i])
				return array[i+1];
		}
		return array[0];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
