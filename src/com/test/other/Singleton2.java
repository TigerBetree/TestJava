package com.test.other;

public class Singleton2 {

	private static class MySingletonHolder {
		private static MySingleton instance = new MySingleton();
	}

	public static MySingleton getInstance() {
		return MySingletonHolder.instance;
	}

	static class MySingleton {

	}
}

