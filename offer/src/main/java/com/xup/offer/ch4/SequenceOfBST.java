package com.xup.offer.ch4;

import java.util.Arrays;

public class SequenceOfBST {

	public boolean VerifySquenceOfBST(int [] sequence) {
		if (sequence == null || sequence.length <= 0)
			return false;
		int len = sequence.length;
		int index = len - 1;
		/*
		 * 找左右子树边界
		 */
		for (; index >= 0; index--) {
			if (sequence[index] < sequence[len - 1])
				break;
		}
		/*
		 * 如果左子树有节点大于根节点，则不是搜索二叉树
		 */
		for (int i = 0; i <= index; i++) {
			if (sequence[i] > sequence[len - 1])
				return false;
		}
		
		/*
		 * 检查左子树
		 */
		boolean flag = true;
		if (index > 0)
			flag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, index + 1));
		/*
		 * 检查右子树
		 */
		if (flag && index < len - 2)
			flag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, index + 1, len -1));
		return flag;
	}
	
	

	public static void main(String[] args) {
		System.out.println(new SequenceOfBST().VerifySquenceOfBST(new int[]{5,7,6,9,11,10,8}));
		System.out.println(new SequenceOfBST().VerifySquenceOfBST(new int[]{7,4,6,5}));

	}

}
