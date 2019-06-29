package com.xup.offer.ch2;

public class FrogJumpFloor {
	
	public int JumpFloor(int target) {
		if (target <= 0)
			return 0;
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		int a = 1, b = 2, c = 0;
		for (int i = 3; i <= target; i++) {
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
