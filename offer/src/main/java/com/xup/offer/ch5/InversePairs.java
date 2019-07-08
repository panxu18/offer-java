package com.xup.offer.ch5;

public class InversePairs {
	
	public int inverseParis(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		return inverseParisInRange(array, 0, array.length, new int[array.length]);
	}
	
	/**
	 * 通过归并排序统计逆序对，其中防止整数溢出需要对1000000007取模
	 * @param array
	 * @param start 区间起始索引，包含在区间内
	 * @param end 区间终止索引，不包含在区间内
	 * @return
	 */
	private int inverseParisInRange(int[] array, int start, int end, int[] temp) {
		if (end - start <= 1)
			return 0;
		int sum = 0;
		int mid = (end + start) / 2;
		int leftSum = inverseParisInRange(array, start, mid, temp);
		int rightSum = inverseParisInRange(array, mid, end, temp);
		int leftIndex = start;
		int rightIndex = mid;
		int resultIndex = start;
		for (; leftIndex < mid && rightIndex < end; resultIndex++) {
			if (array[rightIndex] < array[leftIndex]) {
				temp[resultIndex] = array[rightIndex++];
				sum += (mid - leftIndex);
				if (sum > 1000000007)
					sum %= 1000000007;
			} else
				temp[resultIndex] = array[leftIndex++];
		}
		while (leftIndex < mid) {
			temp[resultIndex++] = array[leftIndex++];
		}
		while (rightIndex < end)
			temp[resultIndex++] = array[rightIndex++];
		resultIndex = start;
		while (resultIndex < end)
			array[resultIndex] = temp[resultIndex++];
		return (sum + leftSum + rightSum)%1000000007;
	}

	public static void main(String[] args) {
		System.out.println(new InversePairs().inverseParis(new int[]{7,5,6,4}));
	}
}
