package com.xup.offer.ch2;

public class FindInPartiallySortedMatrix {
	
	public boolean Find(int target, int[][] array) {
		/*
		 * 空数组检查
		 */
		if (array.length <= 0 || array[0].length <= 0)
			return false;
		
		int row = 0;
		int col = array[0].length-1;
		while (col >= 0 && row < array.length) {
			if (array[row][col] == target)
				return true;
			if (array[row][col] > target) 
				col--;
			else
				row++;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] m = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12},
			{4, 7, 10, 13}, {6, 8, 11, 15}};
		System.out.println(new FindInPartiallySortedMatrix().Find(5, m));

	}

}
