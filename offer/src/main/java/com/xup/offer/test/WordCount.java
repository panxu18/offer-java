package com.xup.offer.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordCount {
	
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        ArrayList<String> array = new ArrayList<>();
//        for (int i = 0; i < n; i++)
//        	array.add(sc.nextLine());
//        int ans = array.stream().collect(Collectors.groupingBy(word -> alphabetize(word))).keySet().size();
//        System.out.println(ans);
//    }
	
	/**
	 * 将字符串循环位移得到一种最小的字符串
	 * @param s
	 * @return
	 */
	private static String alphabetize(String s) {
		char[] array = s.toCharArray();
		//找到最小的字符
		char firstChar = array[0];
		int head = 0;
		for (int i = 0; i< array.length; i++) {
			if (array[i] < firstChar) {
				firstChar = array[i];
				head = i;
			}
		}
		//选择候选头字符
		for (int i = head + 1; i < array.length; i++) {
			if (array[i] == firstChar) {
				for (int j = 1; j < array.length; j++) {
					char temp1 = array[(head + j) % array.length];
					char temp2 = array[(i + j) % array.length];
					if (temp1 > temp2){
						head = i;
						break;
					} else if (temp1 < temp2)
						break;
				}
			}
		}
		char[] ret1 = Arrays.copyOfRange(array, head, array.length);
		char[] ret2 = Arrays.copyOfRange(array, 0, head);
		
		return new String(ret1).concat(new String(ret2));
	}
	public static void main(String[] args) {
		System.out.println(alphabetize("abba"));
	}
}
