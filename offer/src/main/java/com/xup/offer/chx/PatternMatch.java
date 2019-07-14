package com.xup.offer.chx;

import java.util.Arrays;

public class PatternMatch {
	public boolean match(char[] str, char[] pattern)
	{
		if (str == null || pattern == null)
			return false;
		// 模式匹配完时，字符串匹配完则匹配正确，否则错误
		if (pattern.length == 0) {
			if (str.length == 0)
				return true;
			return false;
		}
		// 匹配单字符
		if (pattern.length == 1 || pattern[1] != '*') {
			if (str.length <= 0 || 
					(pattern[0] != '.' && str[0] != pattern[0]))
				return false;
			return match(Arrays.copyOfRange(str, 1, str.length),
					Arrays.copyOfRange(pattern, 1, pattern.length));
		}
		// 匹配*
		else {
			return match(str, Arrays.copyOfRange(pattern, 2, pattern.length)) // 模式后移
					|| ((str.length > 0 && (pattern[0] == '.' || str[0] == pattern[0])) // 字符串后移
							&& (match(Arrays.copyOfRange(str, 1, str.length), pattern) 
									|| match(Arrays.copyOfRange(str, 1, str.length), 
											Arrays.copyOfRange(pattern, 2, pattern.length)))); 
		}
	}
	
	public static void main(String [] args) {
		System.out.println(new PatternMatch().match("bcbbabab".toCharArray(), ".*a*a".toCharArray()));
	}
}
