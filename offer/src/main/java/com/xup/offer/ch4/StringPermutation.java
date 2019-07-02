package com.xup.offer.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class StringPermutation {

	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = null;
		if (str == null || str.length() <= 0)
			return new ArrayList<>(0);
		result = permutation(str.toCharArray());
//		result = permutationWithoutCopy(str.toCharArray(), 0);
		Collections.sort(result);
		return result;
		
	}
	
	StringBuffer sb = new StringBuffer();
	ArrayList<String> result = new ArrayList<>();
	private ArrayList<String> permutation(char[] str) {
		if (str.length == 0) {
			result.add(sb.toString());
		} else {
			for (int i = 0; i < str.length; i++) {
				// 跳过重复的排列
				if (i != 0 && str[i] == str[0])
					continue;
				// 将字符加入序列
				sb.append(str[i]);
				swap(str, i, 0);
				permutation(Arrays.copyOfRange(str, 1, str.length));
				// 将字符从序列中移出
				sb.delete(sb.length() - 1, sb.length());
			}
		}
		return result;
	}
	
	/*
	 * 在原字符串上进行排列，减少字符串的拷贝
	 */
	private ArrayList<String> permutationWithoutCopy(char[] str, int start) {
		if (start == str.length) {
			result.add(String.valueOf(str));
		} else {
			for (int i = start; i < str.length; i++) {
				// 跳过重复的排列
				if (i != start && str[i] == str[start])
					continue;
				swap(str, start, i);
				permutationWithoutCopy(str, start + 1);
				swap(str, start, i);
			}
		}
		return result;
	}
	
	private void swap(char[] str, int i, int j) {
		char c = str[i];
		str[i] = str[j];
		str[j] = c;
	}
	
	
	
	public static void main(String[] args) {
		String str = "abc";
		System.out.println(new StringPermutation().Permutation(str));
	}
}
