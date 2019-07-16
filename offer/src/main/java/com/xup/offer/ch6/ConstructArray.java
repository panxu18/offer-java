package com.xup.offer.ch6;

import java.util.stream.IntStream;

public class ConstructArray {
	/**
	 * 保存数组最后n位的乘积
	 * @param A
	 * @return
	 */
	public int[] multiply(int[] A) {
		if (A == null || A.length <= 1) {
			return new int[0];
		}
		int[] productI2N = new int[A.length];
		productI2N[A.length - 1] = 1;
		for (int i = A.length - 2; i >= 0; i--) {
			productI2N[i] = productI2N[i + 1] * A[i + 1];
		}
		int[] B = new int[A.length];
		int product = 1; //前n项乘积
		for (int i = 0; i < B.length; i++) {
			B[i] = product *  productI2N[i];
			product *= A[i];
		}
		return B;
	}
	
	public static void main(String[] args) {
		IntStream.of(new ConstructArray().multiply(new int[]{1,2,3,4,5})).forEach(
				a->System.out.println(a));
	}
}
