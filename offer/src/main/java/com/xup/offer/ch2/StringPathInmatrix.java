package com.xup.offer.ch2;

public class StringPathInmatrix {

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	{
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathWithRecurency(matrix, rows, cols, str, 0, i, j))
					return true;
			}
		}
		return false;
	}

	/**
	 * 递归判断上下左右四个元素是否可以构成后续的路径，
	 * 已遍历过的元素设置为#，递归结束后恢复原来的字符 
	 */
	private boolean hasPathWithRecurency(char[] matrix, int rows, int cols, 
			char[] str, int index, int row, int col) {
		if (index == str.length)
			return true;
		if (row < 0 || row >= rows
				|| col < 0 || col >= cols)
			return false;
		char ch = matrix[row*cols + col];
		if (ch == str[index]) {
			matrix[row*cols + col] = '#';
			if (hasPathWithRecurency(matrix, rows, cols, str, index + 1, row - 1, col) 
					|| hasPathWithRecurency(matrix, rows, cols, str, index + 1, row + 1, col)
					|| hasPathWithRecurency(matrix, rows, cols, str, index + 1, row, col - 1)
					|| hasPathWithRecurency(matrix, rows, cols, str, index + 1, row, col + 1)) {
				matrix[row*cols + col] = ch;
				return true;
			}
			matrix[row*cols + col] = ch;
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[] matrix = "abtgcfcsjdeh".toCharArray();
		System.out.println(new StringPathInmatrix().hasPath(matrix, 3, 4, "aacjdfbtcehsg".toCharArray()));
	}
}
