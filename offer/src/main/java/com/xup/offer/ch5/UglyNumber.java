package com.xup.offer.ch5;

import java.util.ArrayList;

public class UglyNumber {
	
	/**
	 * 定义一个与计算出来的数组，保存丑数
	 * 如果要计算下一丑数，那么下一丑数一定是数组中某个丑数的2、3或5倍，
	 * 因此只要将数组中值分别乘上2、3、5，然后找到大于数组中最大值的最小值。
	 * 如果每次都1开始计算，那么会有很多重复计算，因此只要保存
	 * @param index
	 * @return
	 */
	public int getUglyNumber(int index) {
		if (index <= 0)
			return 0;
		ArrayList<Integer> uglyNumbers = new ArrayList<>();
		uglyNumbers.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (uglyNumbers.size() < index) {
			int min2 = 2 * uglyNumbers.get(i2);
			int min3 = 3 * uglyNumbers.get(i3);
			int min5 = 5 * uglyNumbers.get(i5);
			int min = Math.min(min2, Math.min(min3, min5));
			uglyNumbers.add(min);
			if (min == min2) i2++;
			if (min == min3) i3++;
			if (min == min5) i5++;
		}
		return uglyNumbers.get(uglyNumbers.size() - 1);
	}
	
	public static void main(String[] args) {
	}	
	
}
