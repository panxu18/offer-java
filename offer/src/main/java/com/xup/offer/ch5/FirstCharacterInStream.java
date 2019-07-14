package com.xup.offer.ch5;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstCharacterInStream {
	
	Map<Integer, Integer> map = new HashMap<>();
	int index = 0;
	//Insert one char from stringstream
    public void insert(char ch)
    {
        if (map.get((int)ch) != null)
        	map.remove((int)ch);
        else
        	map.put((int)ch, index);
        index++;
    }
  //return the first appearence once char in current stringstream
    public char firstAppearingOnce()
    {
    	int temp = Integer.MAX_VALUE;
    	int key = '#';
    	for (Entry<Integer, Integer> entry : map.entrySet()) {
    		if (entry.getValue() < temp){
    			temp = entry.getValue();
    			key = entry.getKey();
    		}
    	}
    	return (char) key;
    }
    public static void main(String[] args) {
    	String s = "google";
    	FirstCharacterInStream stream = new FirstCharacterInStream();
    	for (char ch : s.toCharArray()) {
    		stream.insert(ch);
    		System.out.println(stream.firstAppearingOnce());
    	}
    }
}
