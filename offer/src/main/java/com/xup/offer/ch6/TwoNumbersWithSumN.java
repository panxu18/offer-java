package com.xup.offer.ch6;

import java.util.ArrayList;

public class TwoNumbersWithSumN {

	public ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
		if (array == null || array.length <= 0
				|| sum <= 0)
			return new ArrayList<>(0);
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			if (array[low] + array[high] > sum)
				high--;
			else if (array[low] + array[high] < sum)
				low++;
			else
				break;
		}
		if (low < high) {
			ArrayList<Integer> result = new ArrayList<>(2);
			result.add(array[low]);
			result.add(array[high]);
			return result;
		} else
			return new ArrayList<>(0);
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,2,4,7,11,15};
		System.out.println(new TwoNumbersWithSumN().findNumbersWithSum(a, 15));
	}
}
