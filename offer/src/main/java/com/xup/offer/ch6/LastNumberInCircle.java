package com.xup.offer.ch6;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LastNumberInCircle {

	public int lastRemaining(int n, int m) {
		if (n <= 0 || m <= 0)
			return -1;
		if (n == 1)
			return 0;
		ArrayList<Integer> circle = (ArrayList<Integer>) IntStream
				.iterate(0, a -> a + 1)
				.limit(n)
				.boxed()
				.collect(Collectors.toList());
		int index = 0; 
		while (circle.size() > 1) {
			index = (index + m - 1) % circle.size();
			circle.remove(index);
		}
		return circle.get(0);
	}
	
	/**
	 * 首先我们定义一个函数f(s,n,m),这个函数表示在n个数中，从索引为s开始依次去掉第m个数后，
	 * 最后剩下的数的索引。
	 * 1 f(s,n,m) = (f(0,n,m) + s) mod n
	 * 2 f(0,n,m) = (f(0,n-1,m) + ((m-1) mod n) + 1) mod n
	 * 			  = (f(0,n-1,m) + m) mod n
	 * 公式1很简单，下面解释一下公式2。
	 * 0 1 2 3 4 5 6 7 8
	 * 用f计算上面这个序列，s = 0， m = 5。
	 * 首先去掉第5个数4之后，在剩下的8个数字中从5开始继续去掉下一数。
	 * 如果f(4,8,5)可以计算，那么假设最后剩下数的索引为i。
	 * 现在需要根据索引i来计算在长度为9的序列中对应的索引k，
	 * 以上面的序列为例，如果 0 <= i <=3，那么k=i，
	 * 如果i>3,那么k=(i+1) mod 9。
	 * 
	 * 按照上面计算方法的话，我们需要判断f(4,8,5)的大小，
	 * 如果将5作为序列第一数，3作为最后一个数，也就是计算f(0,8,5)，就能得到相对数字4的偏移，
	 * 从而就能算出在长度为9的序列中的索引。
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public int lastRemaining2(int n, int m) {
		if (n <= 0 || m <= 0)
			return -1;
		if (n == 1)
			return 0;
		return (lastRemaining2(n-1, m) + (m-1) % n + 1) % n;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new LastNumberInCircle().lastRemaining2(9, 5));
	}
}
