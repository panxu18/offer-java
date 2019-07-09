package com.xup.offer.ch6;

import java.util.ArrayList;

public class FindContinuousSequenceSumOfN {
	
	/**
	 * 从1开始遍历列表，找到至少连续两个的序列其和为给定的值sum。
	 * 如果序列的和大于sum那么缩小序列范围，即序列丢掉一个最小值，
	 * 如果序列的和小于sum那么增加序列范围，即序列增加一个最大值。
	 * 如果序列长度为1，则找到所有的解。
	 * @param sum
	 * @return
	 */
	public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
		if (sum < 3)
			return new ArrayList<ArrayList<Integer>>(0);
		ArrayList<ArrayList<Integer>> resultAll = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		int low = 1;
		int high = 2;
		result.add(low);
		result.add(high);
		while (low < high) {
			int tempSum = (low + high) * (high - low + 1) / 2;
			if (tempSum < sum) 
				result.add(++high);
			else{
				if (tempSum == sum)
					resultAll.add(new ArrayList<>(result));
				low = result.remove(0) + 1;
			}
				
		}
		return resultAll;
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer> > result = new FindContinuousSequenceSumOfN().findContinuousSequence(15);
		System.out.println(result);
	}
}
