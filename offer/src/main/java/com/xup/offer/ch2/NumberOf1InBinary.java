package com.xup.offer.ch2;

import java.util.Arrays;

public class NumberOf1InBinary {

	public int NumberOf1(int n) {
		int c = 0;
		while (n != 0) {
			if ( (n & 1) == 1)
				c++;
			n = n >>> 1;
		}
		return c;	
	}

	public static void main(String[] args) {
		int a = 0x80000000;
		System.out.println(a << 1);

	}

}
