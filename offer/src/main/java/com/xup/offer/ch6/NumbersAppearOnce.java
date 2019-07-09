package com.xup.offer.ch6;

public class NumbersAppearOnce {

	/**
	 * 两个相同的数进行异或结果为0，一个数与0异或等于这个数本身。
	 * 先根据两个不同的数的不相同的位将数组分为两部分，然后对两个部分逐元素异或
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		if (array == null || array.length < 2 ||
				num1 == null || num1.length < 1
				|| num2 == null || num2.length < 1)
			return;
		int sum = 0;
		for (int i = 0; i < array.length; i++)
			sum ^= array[i];
		int s = 1;
		while (s > 0) {
			if ((sum & s) > 0)
				break;
			else
				s = s << 1;
		}
		num1[0] = 0;
		num2[0] = 0;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & s) == 0)
				num1[0] = num1[0] ^ array[i];
			else
				num2[0] = num2[0] ^ array[i];
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{2,4,3,6,3,2,5,5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		new NumbersAppearOnce().findNumsAppearOnce(a, num1, num2);
		System.out.println(num1[0]);
		System.out.println(num2[0]);
	}

}
