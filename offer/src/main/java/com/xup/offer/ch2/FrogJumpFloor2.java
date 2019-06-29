package com.xup.offer.ch2;

public class FrogJumpFloor2 {
	
	public int JumpFloorII(int target) {
		if (target < 0)
			throw new IllegalArgumentException();
		if (target == 0)
			return 0;
		return 1 << (target-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
