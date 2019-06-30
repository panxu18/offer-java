package com.xup.offer.ch4;

import java.util.ArrayList;

import org.omg.CORBA.IdentifierHelper;

public class PrintMatrix {
	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		if (matrix == null || matrix.length <= 0)
			return new ArrayList<>(0);
		int endRow = matrix.length-1;
		int endCol = matrix[0].length-1;
		int startRow = 0;
		int startCol = 0;
		ArrayList<Integer> result = new ArrayList<>();
		
		while (startRow <= endRow && startCol <= endCol) {
			/*
			 * 第一行
			 */
			for (int col = startCol; col <= endCol; col++)
				result.add(matrix[startRow][col]);
			/*
			 * 最后一列 
			 * 只有一行，则不用后续操作
			 */
			if (endRow - startRow < 1)
				break;
			for (int row = startRow + 1; row <= endRow; row++)
				result.add(matrix[row][endCol]);
			/*
			 * 处理最后一行
			 * 如果只有一行或者只有一列，则不用后续操作
			 */
			if (endCol - startCol < 1)
				break;
			for (int col = endCol -1; col >= startCol; col--)
				result.add(matrix[endRow][col]);
			/*
			 * 处理第一列
			 * 如果只有两行或者只有一列，则不用后续操作
			 */
			if (endRow - startRow < 2)
				break;
			for (int row = endRow -1; row > startRow; row--)
				result.add(matrix[row][startCol]);
			startRow += 1;
			startCol += 1;
			endRow -= 1;
			endCol -= 1;
			
		}
		return result;
	}
	
	public static void main (String[] args) {
		int[][] array = new int[][]{{1, 2},{3, 4},{5, 6},{7,8},{9,10}};
		System.out.println(new PrintMatrix().printMatrix(array));
	}
}
