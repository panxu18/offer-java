package com.xup.offer.ch5;

import java.util.HashMap;

public class FirstNotRepeatingNumber {
	
	public int FirstNotRepeatingChar(String str) {
		if (str == null || str.length() <= 0)
			return -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		char[] strArray = str.toCharArray();
		for (char c : strArray) {
			if (map.get((int)c) != null)
				map.put((int)c, map.get((int)c) + 1);
			else
				map.put((int)c, 1);
		}
		for (int i = 0; i < strArray.length; i++)
			if (map.get((int)strArray[i]) == 1)
				return i;
        return 0;
    }
	
	public static void main(String[] args) {
		System.out.println(new FirstNotRepeatingNumber().FirstNotRepeatingChar("google"));
	}
}
