package com.xup.offer.ch6;


public class Accumulate {
	public int sum(int n) {
		int sum = n;
		boolean ans = (n>0)&&((sum+=sum(n-1))>0);
		return sum;
	}
}
