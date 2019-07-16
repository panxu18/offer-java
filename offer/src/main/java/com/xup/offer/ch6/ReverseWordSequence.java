package com.xup.offer.ch6;

public class ReverseWordSequence {
	public String reverseSentence(String str) {
        if (str == null || str.length() < 1)
            return str;
        char[] strArray = new char[str.length()];
        int index = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ')
                strArray[index++] = ' ';
            else {
                int start = i;
                while (start >= 0 && str.charAt(start) != ' ')
                    start--;
                for (int offset = start + 1; offset <= i; offset++) {
                    strArray[index++] = str.charAt(offset);
                }
                if (start >= 0) {
                    i = start;
                    strArray[index++] = ' ';
                } else
                    break;
            }
        }
        return String.valueOf(strArray);
    } 
	
	public static void main(String[] args) {
		System.out.println(new ReverseWordSequence().reverseSentence("student. a am I"));
	}
}
