package com.xup.offer.ch2;

public class RobotMove {
	/**
	 * 不需要遍历所有坐标点，因为不能跨过不满足的条件的坐标点
	 */
	public int movingCount(int threshold, int rows, int cols) {
		boolean[] visited = new boolean[rows * cols];
		return movingCountWithRecurency(threshold, rows, cols, 0, 0, visited);
	}

	private int movingCountWithRecurency(int threshold, int rows, int cols,
			int row, int col, boolean[] visited) {
		if (row < 0 || row >= rows 
				|| col < 0 || col >= cols
				|| visited[row * cols + col] == true
				|| getDigitSum(row) + getDigitSum(col) > threshold)
			return 0;
		visited[row * cols + col] = true;
		int count = 1 + movingCountWithRecurency(threshold, rows, cols, row, col -1, visited);
		count += movingCountWithRecurency(threshold, rows, cols, row, col + 1, visited);
		count += movingCountWithRecurency(threshold, rows, cols, row - 1, col, visited);
		count += movingCountWithRecurency(threshold, rows, cols, row + 1, col, visited);
		return count;
	}

	private int getDigitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += (num % 10);
			num /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new RobotMove().movingCount(10, 1, 100));
	}
}
