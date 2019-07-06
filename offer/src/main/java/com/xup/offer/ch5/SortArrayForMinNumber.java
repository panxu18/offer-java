package com.xup.offer.ch5;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortArrayForMinNumber {
	/**
	 * 数字a，b的两种组合ab和ba进行对比，如果ab小于ba，
	 * 则a要排在前面，通过这种方法对整个数组排序即可
	 * @param numbers
	 * @return
	 */
	public String sortArray(int [] numbers) {
		return IntStream.of(numbers)
				.mapToObj(val->String.valueOf(val))
				.sorted((a, b)->{
					String str1 = a + b;
					String str2 = b + a;
					return str1.compareTo(str2);
				})
				.collect(Collectors.joining());
	}

	public static void main(String[] args) {
		System.out.println(new SortArrayForMinNumber().sortArray(new int[]{3,331,2, 23,321,213}));
	}
}
