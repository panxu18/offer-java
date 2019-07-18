package com.xup.offer.chx;

import java.util.ArrayList;

public class MaxInWindows {
	
	
	public ArrayList<Integer> maxInWindows(int [] num, int size) {
		ArrayList<Integer> result = new ArrayList<>(num.length);
		ArrayList<Integer> queue = new ArrayList<>(size);
		for (int e : num) {
			queue.add(e);
			for (int i = 0; i < queue.size(); i++) {
				if(queue.get(i) < e)
					queue.set(i, e);
			}
			if (queue.size() == size)
				result.add(queue.remove(0));
		}
        return result;
    }
	
	public static void main(String[] args) {
		int[] array = new int[]{2,3,4,2,6,2,5,1};
		new MaxInWindows().maxInWindows(array, 3).stream().forEach(System.out::println);
	}

}
