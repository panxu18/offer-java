package com.xup.offer.ch5;

public class NumberOf1 {
	
	public int NumberOf1Between1AndN_Solution(int n) {
//		return getNumberOf1Between1AndN(n);
		return getNumberOf1Between1AndNWithoutRecursion(n);
	}
	
	/**
	 * 1的个数和n的位数有关，而且是固定值。
	 * 设d[k]为[1,10^k-1]范围内所有1的个数，例如d[1] = 1,d[2]=11
	 * 那么对于任意的[1,n]范围内的1的个数，如果已知n是k位数，n的最高位为m
	 * 那么1的个数分为下面2中情况
	 * m大于1，d[k-1]*m 加上 [1,n-10^(k-1)*m]中1的个数 加上10^(k-1)
	 * m等于1，d[k-1]*1  加上  [1,n-10^(k-1)*1]中1的个数 加上 n-10^(k-1)*1+1
	 * 
	 * 以678为例，其中第一部分为最高位为0到5时其他位包含的1的个数，
	 * 第二部分为除去最高位剩下的部分包含的1的个数
	 * 第三部分为最高位为1的数的个数
	 * 
	 * d[k]的计算公式为
	 * d[k] = d[k-1]*10 + 10^(k-1)
	 * @param n
	 * @return
	 */
	public int getNumberOf1Between1AndN(int n) {
		if (n < 1)
			return 0;
		/*
		 * 先计算d[k]
		 */
		int dp = 0; 
		int mod = 1;
		//n为k位，循环k-1次
		while (n / mod >= 10) {
			dp = dp * 10 + mod;
			mod *= 10;
		}
		int m = n / mod;
		if (m  > 1) 
			return dp * m + getNumberOf1Between1AndN(n - mod * m) + mod;
		else
			return dp * m + getNumberOf1Between1AndN(n - mod * m) + n - mod + 1;
	}
	
	/**
	 * 在递归解法中需要对除去最高的后剩下的部分递归求解
	 * 使用循环从低位开始求解
	 * 
	 * 例如608，08已经在之前解决了，所以对最高位6求解时，
	 * 只需要将600中1的个数和08中1的个数相加。
	 * 
	 * @param args
	 */
	public int getNumberOf1Between1AndNWithoutRecursion(int n) {
		if (n < 1)
			return 0;
		int count = 0;
		int dp = 0;
		int mod = 1;
		//n为k位循环k次
		while (n / mod > 0) {
			int bit = n / mod % 10;
			if (bit > 1)
				count += dp * bit + mod;
			else if (bit == 1)
				count += dp * bit + n % mod + 1;
			dp = dp * 10 + mod;
			mod *= 10;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new NumberOf1()
				.getNumberOf1Between1AndNWithoutRecursion(10000));
	}

}
