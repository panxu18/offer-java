package com.xup.offer.ch5;

public class MoreThanHalfNumber {
	public int MoreThanHalfNum_Solution(int [] array) {
		if (array == null || array.length <= 0)
			return 0;
//		return findMoreThanHanlNumberInPlace(array);
		return findMoreThanHanlNumberByPartion(array);
	}
	
	/**
	 * 如果存在个数超过数组长度一半的关键元素，每次去掉两个不同元素，
	 * 最终剩下的一定是关键元素 
	 * @param array
	 * @return
	 */
	private int findMoreThanHanlNumberInPlace(int [] array) {
		if (array == null || array.length <= 0)
			return 0;
		int count = 0;
		int keyNumber = array[0];
		for (int v : array) {
			if (count == 0) {
				keyNumber = v;
				count++;
			}
			else {
				if (v != keyNumber)
					count--;
				else
					count++;
			}
		}
		return isKeyNumber(array, keyNumber);
	}
	
	private int isKeyNumber(int[] array, int key) {
		int count = 0;
		for (int v : array) {
			if (v == key)
				count++;
		}
		if (count > array.length / 2)
			return key;
		else 
			return 0;
	}
	
	/**
	 * 对指定区间进行partion
	 * @param array 原数组
	 * @param start 区间开始索引，包含在区间内
	 * @param end 区间结束索引，不包含在区间内
	 * @return 原区间第一个值partion后的索引
	 */
	private int partion(int [] array, int start, int end) {
		if (start >= end)
			throw new IllegalArgumentException();
		int left = start;
		int right = end - 1;
		int key = array[left];
		while (left < right) {
			while (left < right && array[right] >= key)
				right--;
			array[left] = array[right];
			while (left < right && array[left] < key)
				left++;
			array[right] = array[left];
		}
		array[left] = key;
		return left;
		
	}
	
	/**
	 * 查找中位数，如果值等于中位数的元素的个数是否超过数组长度一半 ，那么中位数就是
	 * 所求的元素，否则返回0
	 * @param array 原数组
	 * @return
	 */
	private int findMoreThanHanlNumberByPartion(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		int left = 0;
		int right = array.length;
		int index = left;
		while (left < right) {
			index = partion(array, left, right);
			if (index < array.length / 2)
				left = index + 1;
			else if (index > array.length / 2)
				right = index - 1;
			else
				break;
		}
		return isKeyNumber(array, array[index]);
	}
	public static void main(String[] args) {
		System.out.println(new MoreThanHalfNumber().MoreThanHalfNum_Solution(
				new int[]{1,2,3,2,2,2,5,4,2}));
	}

}
