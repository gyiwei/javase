package com.gyw.泛型;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 普通类 泛型通配符？的使用
 * @author Administrator
 *
 */
public class GeneralClass {
	
	private String name;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("e");
//		forIntegerList(list1);
		forStringList(list1);
//		forObjectList(list1);
		forAllList(list1);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		forIntegerList(list2);
//		forStringList(list2);
//		forObjectList(list2);
		forAllList(list2);
		
		//
		List<?> list3 = new ArrayList<>();
		forAllList(list3);
	}	
	
	public static void forIntegerList(List<Integer> list) {
		
	}
	public static void forStringList(List<String> list) {
		
	}
	public static void forObjectList(List<Object> list) {
		
	}
	/**
	 * 泛型通配符?的使用
	 * @param list
	 */
	public static void forAllList(List<?> list) {
		Iterator<?> iterator = list.iterator();
		while(iterator.hasNext()) {
			Object o = iterator.next();
			System.out.println(o);
		}
	}
	/**
	 * 只能传入Me及其我的子类作为泛型
	 * @param list
	 */
	public static void 泛型通配符的上限制(ArrayList<? extends Me> list) {
		
	}
	
	/**
	 * 只能传入Me及其我的超类作为泛型
	 * @param list
	 */
	public static void 泛型通配符的下限制(ArrayList<? super Me> list) {
		
	}
	
}
