package com.xup.offer.ch2;

public class RectCover {
	
	public int RectCover(int target) {
		if (target < 0)
			throw new IllegalArgumentException();
		if (target == 0)
			return 0;
		int a = 1, b = 1, c = 0;
		for (int i = 2; i <= target; i++) {
			c = b;
			b = a + b;
			a = c;
		}
		return b;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
