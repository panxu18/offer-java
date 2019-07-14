package com.xup.offer.ch6;

import java.util.stream.IntStream;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class ConstructArray {
	/**
	 * 构建数组保存乘积
	 * @param A
	 * @return
	 */
	public int[] multiply(int[] A) {
		if (A == null || A.length <= 1) {
			return new int[0];
		}
		//0~n-2
		int[] productZero2I = new int[A.length - 1];
		//1~n-1
		int[] productI2N = new int[A.length - 1];
		productZero2I[0] = A[0];
		for (int i = 1; i < A.length - 1; i++) {
			productZero2I[i] = A[i] * productZero2I[i - 1];
		}
		productI2N[A.length - 2] = A[A.length - 1];
		for (int i = A.length - 3; i >= 0; i--) {
			productI2N[i] = productI2N[i + 1] * A[i + 1];
		}
		int[] B = new int[A.length];
		B[0] = productI2N[0];
		B[B.length - 1] = productZero2I[A.length - 2];
		for (int i = 1; i < B.length - 1; i++) {
			B[i] = productZero2I[i - 1] * productI2N[i];
		}
		return B;
	}
	
	public static void main(String[] args) {
		IntStream.of(new ConstructArray().multiply(new int[]{1,2,3,4,5})).forEach(
				a->System.out.println(a));
	}
}
