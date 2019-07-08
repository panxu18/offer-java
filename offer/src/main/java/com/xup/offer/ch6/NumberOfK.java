package com.xup.offer.ch6;

public class NumberOfK {
	
	public int getNumberOfK(int [] array , int k) {
		if (array == null || array.length <= 0)
			return 0;
		int left = firstIndex(array, k);
		int right = lastIndex(array, k);
		if (left != -1)
			return right - left + 1;
		else
			return 0;
    }
	
	/**
	 * 在数组中找k第一次出现的索引，如果数组中没有k则返回-1
	 * @param array
	 * @param k
	 * @return
	 */
	private int firstIndex(int [] array , int k) {
		int low = 0, high = array.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (array[mid] < k) {
				low = mid + 1;
			} else if (array[mid] > k) {
				high = mid - 1;
			} else {
				if (mid > low && array[mid - 1] == k)
					high = mid - 1;
				else
					return mid;
			}
		}
		return -1;
	}

	/**
	 * 在数组中找k最后一次出现的索引，如果数组中没有k则返回-1
	 * @param array
	 * @param k
	 * @return
	 */
	private int lastIndex(int [] array , int k) {
		int low = 0, high = array.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (array[mid] < k) {
				low = mid + 1;
			} else if (array[mid] > k) {
				high = mid - 1;
			} else {
				if (mid < high && array[mid + 1] == k)
					low = mid + 1;
				else
					return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(new NumberOfK().getNumberOfK(new int[]{1,2,3,3,3,3,4,5}, 6));
	}
}
