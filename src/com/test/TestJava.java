package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestJava {

	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		System.out.println(test4());
	}
	
	private static int test4(){
		int b = 10;
		try {
			System.out.println("try...catch...finally");
			//System.exit(0);
			return b / 0;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			System.out.println("finally.");
		}
		
		return b + 30;
	}

	private static void test3() {
		List<Integer> mList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			mList.add(i);
		}

		Iterator<Integer> mIterator = mList.iterator();
		while (mIterator.hasNext()) {
			System.out.println(mIterator.next());
		}

		HashMap<Integer, String> mMap = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			mMap.put(i, "str" + i);
		}

		Iterator iter = mMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry ent = (Map.Entry) iter.next();
			Object key = ent.getKey();
			Object value = ent.getKey();
			int hash = hash(key);
			int bucketIndex = (mMap.size() - 1) & hash;

			StringBuilder sb = new StringBuilder();
			sb.append("hash : ").append(hash).append(", bucket index : ").append(bucketIndex);
			sb.append(", ").append(key).append("=").append(value);
			System.out.println(sb.toString());
		}
	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	private static void test1() {
		Person p = new Person("tiger", 31);
		System.out.println(p.name);
		System.out.println(p.age);
	}

	private static void test2() {
		Integer mInteger = 3;// 自动装箱
		int m = mInteger; // 自动拆箱
		System.out.println(mInteger);
		System.out.println(mInteger.intValue());
		System.out.println(m);
	}

}
