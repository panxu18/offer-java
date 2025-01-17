package com.xup.offer.ch5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLeastNumbers {

	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//		return getKLeastNumbers(input, k);
		return getKLeastNumbersWithMaxHeap(input, k);
	}
	
	/**
	 * 对指定区间进行partion
	 * @param array 原数组
	 * @param start 区间开始索引，包含在区间内
	 * @param end 区间结束索引，不包含在区间内
	 * @return 原区间第一个值partion后的索引
	 */
	private int partion(int[] array, int start, int end) {
		if (start >= end)
			throw new IllegalArgumentException();
		int left = start;
		int right = end -1;
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
	 * 对数组进行partion，将返回的索引index与k-1比较 ，
	 * 如果index < k-1，继续对index右边的数组进行partion，
	 * 如果inde > k-1，则对index左边的数组进行partion。
	 * 如果index = k-1，则返回最小的k个数
	 * @param array
	 * @param k
	 * @return
	 */
	private ArrayList<Integer> getKLeastNumbers(int[] array, int k) {
		if (array == null || array.length <= 0
				|| k <= 0 || k > array.length)
			return new ArrayList<>(0);
		int index = 0;
		int left = 0;
		int right = array.length;
		while (left < right) {
			index = partion(array, left, right);
			if (index < k -1)
				left = index + 1;
			else if (index > k - 1)
				right = index;
			else
				break;
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(array[i]);
		}
		return result;
	}
	
	/**
	 * 使用优先队列维持数组中最小k个数
	 * @param array
	 * @param k
	 * @return
	 */
	private ArrayList<Integer> getKLeastNumbersWithMaxHeap(int[] array, int k) {
		if (array == null || array.length <= 0
				|| k <= 0 || k > array.length)
			return new ArrayList<>(0);
		/*
		 * 默认比较函数为升序，即compare返回负值表示左值排在右值前面
		 */
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		for (int i = 0; i < k; i++)
			maxHeap.add(array[i]);
		for (int i = k; i < array.length; i++) {
			if (maxHeap.peek() > array[i]) {
				maxHeap.poll();
				maxHeap.add(array[i]);
			}
				
		}
		return new ArrayList<>(maxHeap);
	}
	
	public static void main(String[] args) {
		System.out.println(new KLeastNumbers().GetLeastNumbers_Solution(
				new int[]{4,5,1,6,2,7,3,8}, 4));
	}
}
