package com.xup.offer.chx;

public class IsNumeric {

	/**
	 * 1、E重复，E出现在第一位, E出现在.的后一位, E出现在最后一位
	 * 2、.重复，.出现在第一，.出现在E之后，.出现在指数或底数最后一位
	 * 3、符号重复，指数的符号只能在E后一位
	 * 4、非法字符
	 * @param str
	 * @return
	 */
	public boolean isNumeric(char[] str) {
		if (str == null || str.length <= 0)
			return false;
		int indexOfE = -1;
		int indexOfPoint = -1;
		int offset = 0;
		//检查符号
		if (str[0] == '-' || str[0] == '+')
			offset = 1;
		else if (str[0] == 'e' || str[0] == '.')
			return false; // E和.不能出现在数字第一位
		//检查字符是否合法以及特殊符号是否重复
		for (int i = offset; i < str.length; i++) {
			 if (str[i] == 'e' || str[i] == 'E') {
				 if (indexOfE < 0 // E不能重复 
						 && (indexOfPoint < 0 || i - indexOfPoint > 1 )) // .不能出现在底数最后一位
					 indexOfE = i;
				 else
					 return false; //有多个E
			 } else if (str[i] == '.') {
				 if (indexOfE < 0 && indexOfPoint < 0) //.不能出现在指数部分
					 indexOfPoint = i;
				 else
					 return false; //有多个.
			 } else if (str[i] == '-' || str[i] == '+') {
				 if (indexOfE < 0 || (str[i - 1] != 'e' && str[i - 1] != 'E'))
					 return false;  // 符号只能紧跟着E
			 } else if (str[i] < '0' || str[i] > '9')
				 return false; // 非法字符
		}
		// E不能出现在最后一位，.不能出现在最后一位且不能出现在E前一位
		if (indexOfE == str.length - 1 || indexOfPoint == str.length - 1)
			return false;
		return true;
	}
	
	public boolean isNumericWithPattern(char[] str) {
		String str1 = String.valueOf(str);
		return str1.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
	}
	
	public static void main(String[] args) {
		System.out.println(new IsNumeric().isNumeric("-e123".toCharArray()));
	}

}
