package com.xup.offer.ch3;

public class Power {

	public double Power(double base, int exponent) {
		double result = 1;
		if (exponent == 0)
			return result;
		/*
		 * 设置倒数标志
		 */
		boolean eFlag = (exponent < 0) ;
		if (eFlag)
			exponent *= -1;
		/*
		 * 设置符号
		 */
		boolean bFlag = (base < 0);
		if (bFlag)
			base *= -1;
		if ((exponent & 1) == 1 && bFlag) {
			result *= -1;
        }
		/*
		 * 主要计算
		 */
		while (exponent != 0) {
			if ((exponent & 1) == 1)
				result *= base;
			exponent >>>= 1;
			base *= base;
		}
		if (eFlag)
			result = 1 / result;
		return result;
		
	}

	public static void main(String[] args) {
		System.out.println(new Power().Power(2, -3));

	}

}
