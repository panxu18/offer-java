package com.xup.offer.ch2;

public class DuplicationInArrayNoEdit {
	
	public int duplicate(int[] a) {
		/*
		 * 空数组检查
		 */
		if (a.length <= 0)
			return -1;
		/*
		 * 元素范围检查
		 */
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 1 || a[i] > a.length)
				throw new IllegalArgumentException();
		}
		/*
		 * 利用二分法查找每个区间是否有重复数字，例如[1,4]中4个数字在数组中
		 * 出现的次数是超过4次,就可以判断出区间[1,4]中有重复数字。
		 */
		int low, mid, high;
		low = 1;
		high = a.length-1;
		while (low < high) {
			mid = (high + low) / 2;
			int leftCount = 0, rightCount = 0;
			for (int i = 0; i < a.length; i++) {
				/*
				 * 统计数字个数
				 */
				if (a[i] >= low && a[i] <= mid)
					leftCount++;
				else if (a[i] > mid && a[i] <= high)
					rightCount++;
				/*
				 * 选择候选区域
				 */
				if (leftCount > (mid - low +1)) {
					high = mid;
					break;
				} else if (rightCount > (high - mid)) {
					low = mid + 1;
					break;
				}
			}
		}
		return low;
	}
	

	public static void main(String[] args) {
		 int[] a = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
		 System.out.println(new DuplicationInArrayNoEdit().duplicate(a));
	}

}
