package com.xup.offer.ch6;

import java.util.Arrays;

public class ContinuesCards {
	/**
	 * @param numbers
	 * @return
	 */
	public boolean isContinuous(int [] numbers) {
		if (numbers == null || numbers.length < 5)
			return false;
		Arrays.sort(numbers);
		int k = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] == 0)
				k--;
			else if (numbers[i + 1] == numbers[i])
				return false;
			else
				k += numbers[i + 1] - numbers[i] - 1;
		}
		return k <= 0;
	 }
	
	
}
