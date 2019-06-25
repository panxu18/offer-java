package com.xup.offer.ch2;

/**
 * 饿汉模式
 * java类加载时会执行<cinit>类初始化，初始化所有静态
 * 变量，以及执行static块，而且<cinit>方法有虚拟机保证只
 * 执行一次，因此HangerSingleton.instance只会被
 * 初始化一次。同时通过将构造函数私有化防止被实例化和被子类继承。
 */
public class HangerSingleton {
	private static HangerSingleton instance = new HangerSingleton();
	
	public static HangerSingleton getInstance() {
		return instance;
	}
	
	private HangerSingleton() {
	}
	
	
	public static void main(String[] args) {
		
	}

}

