package com.xup.offer.ch2;

public class FindInPartiallySortedMatrix {
	
	public boolean find(int[][] m, int e) {
		/*
		 * 空数组检查
		 */
		if (m.length <= 0 || m[0].length <= 0)
			return false;
		
		int row = 0;
		int col = m[0].length-1;
		while (col >= 0 && row < m.length) {
			if (m[row][col] == e)
				return true;
			if (m[row][col] > e) 
				col--;
			else
				row++;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] m = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12},
			{4, 7, 10, 13}, {6, 8, 11, 15}};
		System.out.println(new FindInPartiallySortedMatrix().find(m, 5));

	}

}
