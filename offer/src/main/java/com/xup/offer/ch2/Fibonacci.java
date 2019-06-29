package com.xup.offer.ch2;

public class Fibonacci {
	
	public int Fibonacci(int n) {
		if (n <= 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int a = 1, b = 1, c = 0;
		int i = 3;
		while (i <= n) {
			c = b;
			b = a + b;
			a = c;
			i++;
		}
		return b;
    }

	public static void main(String[] args) {
		

	}

}
