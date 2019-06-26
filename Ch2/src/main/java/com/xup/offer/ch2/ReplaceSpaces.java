package com.xup.offer.ch2;

import java.util.Scanner;

public class ReplaceSpaces {
	
	public String replace(StringBuffer str) {
		/*
		 * 检查空字符串
		 */
		if (str == null || str.length() <=0 )
			throw new IllegalArgumentException();
		
		int oldLen = str.length();
		int spaceCount = 0;
		/*
		 * 统计空格总数,增加str长度
		 */
		for (int i = 0; i < oldLen; i++){
			if (str.charAt(i) == ' ') {
				str.append("  ");
				spaceCount++;
			}
		}
		int head = str.length();
		/*
		 * 将字符后移
		 */
		for (int i = oldLen - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				str.replace(head-3, head, "%20");
				head -= 3;
			} else {
				str.setCharAt(head-1, str.charAt(i));
				head--;
			}
			
		}
		return str.toString();
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(in.nextLine());
		System.out.println(new ReplaceSpaces().replace(sb));
	}

}
