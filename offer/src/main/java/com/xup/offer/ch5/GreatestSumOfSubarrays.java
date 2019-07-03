package com.xup.offer.ch5;

public class GreatestSumOfSubarrays {
	public int FindGreatestSumOfSubArray(int[] array) {
//		return maxSubarray(array);
		return maxSubarrayWithoutExtraArray(array);
	}
	
	/**
	 * 利用动态规划解决，最大子串d[n]表示以索引n结尾的数组的最大子序列和，
	 * d[n] = max{d[n-1] + a[n], 0}, 如果d[n-1]+a[n]为
	 * 负数，那么在后面计算最大子序列时，就不用考虑a[n]了，因此将d[n]
	 * 赋值为0。
	 * @param array
	 * @return
	 */
	private int maxSubarray(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		int[] dp = new int[array.length];
		dp[0] = array[0];
		int sum = Integer.MIN_VALUE;
		for (int i = 1; i < array.length; i++) {
			if (dp[i-1] <= 0)
				dp[i] = array[i];
			else
				dp[i] = array[i] + dp[i-1];
			if (dp[i] > sum)
				sum = dp[i];
		}
		return sum;
		
	}
	
	/**
	 * 由于dp数组中的元素在计算第i个值是需要前一个值，所以通过一个局部变量保存
	 * 上一个元素值，同时再用另一个局部变量保存最大值
	 * @param array
	 * @return
	 */
	private int maxSubarrayWithoutExtraArray(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		int maxSum = Integer.MIN_VALUE;
		int pre = 0;
		for (int v : array) {
			pre = pre > 0 ? pre + v : v;
			maxSum = pre > maxSum ? pre : maxSum;
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{-2,-2,-3,-1,-4, -4};
//		array = new int[]{1,-2,3,10,-4,7,2,-5};
		array = new int[]{-1};
		System.out.println(new GreatestSumOfSubarrays()
				.FindGreatestSumOfSubArray(array));
	}
}
