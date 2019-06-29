package com.xup.offer.ch2;

/**
 * 懒汉模式
 * 与饿汉模式的区别在于instance的初始化交个另外一个类，
 * 在第一次使用instance时即调用getInstance()时，
 * 会加载SingletonUtil，从而会初始化instance。
 */
public class LazySingleton {
	private static class SingletonUtil {
		private static LazySingleton instance = new LazySingleton();
	}
	
	private LazySingleton() {
	}
	
	public LazySingleton getInstance() {
		return SingletonUtil.instance;
	}

	public static void main(String[] args) {
		
	}

}
