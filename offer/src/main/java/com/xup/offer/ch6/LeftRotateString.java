package com.xup.offer.ch6;

public class LeftRotateString {

	public String leftRotateString(String str,int n) {
		if (str == null || str.length() < 2 || n <= 0)
			return str;
		char[] strArray = str.toCharArray();
		reverse(strArray, 0, n-1);
		reverse(strArray, n, str.length()-1);
		reverse(strArray,0,str.length()-1);
		return String.valueOf(strArray);
	}

	private void reverse(char[] strArray, int start, int end) {
		while (start < end) {
			char t = strArray[start];
			strArray[start] = strArray[end];
			strArray[end] = t;
			start++;
			end--;
		}
	}
	

}
