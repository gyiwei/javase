package com.gyw.Collection接口;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test01();
	}

	private static void test01() {
		// TODO Auto-generated method stub
		Collection c = new ArrayList<>();
		String str= "字符串";
		c.add(str);
		System.out.println(c);
		char char2 = 's' ;
		c.add(char2);
		System.out.println(c);
		int i = 1;
		c.add(i);
		System.out.println(c);
		Integer ii = new Integer(2);
		c.add(ii);
		System.out.println(c);
		//遍历集合
		System.out.println("while循环");
		Iterator<Comparable> iterator = c.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
		}
		System.out.println();
		System.out.println("for each循环");
		for (Object object : c) {
			System.out.print(object);
		}
		System.out.println();
//		for (Comparable comparable : c) {
//			System.out.print(comparable);
//		}
//		System.out.println();
		//遍历数组
		Object[] array = c.toArray();
		for (Object object : array) {
			System.out.print(object);
		}
		System.out.println();
	}
	
	

}
